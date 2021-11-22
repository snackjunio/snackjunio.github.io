from hashlib import sha256
import time
import json
from flask import Flask, request
import requests


class Block:
    def __init__(self, index, transaction, timestamp, previous_hash):
        self.index = index
        self.transaction = transaction
        self.timestamp = timestamp
        self.previous_hash = previous_hash
        self.nonce = 0
    
    def compute_hash(self):
        block_string = json.dumps(self.__dict__, sort_keys=True)
        return sha256(block_string.encode()).hexdigest()
    
class Blockchain:
    difficulty = 2
    def __init__(self):
        self.unconfirmed_transaction = []
        self.chain = []
        self.create_genesis_block()
    
    def create_genesis_block(self):
        genesis_block = Block(0, [], time.time(), "0")
        genesis_block.hash = genesis_block.compute_hash()
        self.chain.append(genesis_block)
    
    @property
    def last_block(self):
        return self.chain[-1]
    
    def add_block(self, block, proof):
        previous_hash = self.last_block.hash
        if previous_hash != block.previous_hash:
            return False
        if not self.is_valid_proof(block, proof):
            return False
        block.hash = proof
        self.chain.append(block)
        return True
    
    def is_valid_proof(self, block, block_hash):
        return (block_hash.startswith('0' * Blockchain.difficulty) and block_hash == block.compute_hash())

    def pow(self, block):
        block.nonce = 0
        computed_hash = block.compute_hash()
        while not computed_hash.startswith('0' * Blockchain.difficulty):
            block.nonce += 1
            computed_hash = block.compute_hash()
        return computed_hash
    
    def add_new_transaction(self, transaction):
        self.unconfirmed_transaction.append(transaction)
    
    def mine(self):
        if not self.unconfirmed_transaction:
            return False
        
        last_block = self.last_block

        new_block = Block(index = last_block.index + 1,
            transaction = self.unconfirmed_transaction,
            timestamp = time.time(),
            previous_hash = last_block.hash)
        
        proof = self.pow(new_block)
        self.add_block(new_block, proof)
        self.unconfirmed_transaction = []
        return new_block.index

app = Flask(__name__)
blockchain = Blockchain()

@app.route('/hypt', methods=['GET'])
def get_chain():
    chain_data = []
    for block in blockchain.chain:
        chain_data.append(block.__dict__)
    return json.dumps({"length": len(chain_data),
                        "chain": chain_data})

app.run(debug=True)