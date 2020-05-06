import cv2
import os
import numpy as np
subject = ['', 'Sakura', 'Nako']


def prepare_training_data(data_folder_path):
    dirs = os.listdir(data_folder_path)
    faces = []
    labels = []
    for dir_name in dirs:
        if not dir_name.startswith('s'):
            continue
        label = int(dir_name.replace('s', ''))
        subject_dir_path = data_folder_path + '/' + dir_name
        subject_images_names = os.listdir(subject_dir_path)
        for image_name in subject_images_names:
            if image_name.startswith('.'):
                continue
            image_path = subject_dir_path + '/' + image_name
            image = cv2.imread(image_path)
            # cv2.imshow('Loading...', cv2.resize(image, (400, 500)))
            # cv2.waitKey(100)
            face, rect = detect_face(image)
            if face is not None:
                faces.append(face)
                labels.append(label)
    cv2.destroyAllWindows()
    cv2.waitKey(1)
    cv2.destroyAllWindows()
    return faces, labels


def draw_rectangle(img, rect):
    (x, y, w, h) = rect
    cv2.rectangle(img, (x, y), (x + w, y + h), (0, 255, 0), 2)


def draw_text(img, text, x, y):
    cv2.putText(img, text, (x, y), cv2.FONT_HERSHEY_PLAIN, 1.5, (0, 255, 0), 2)


def detect_face(img):
    face_path = 'opencv/haarcascade_frontalface_default.xml'
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    face_cascade = cv2.CascadeClassifier(face_path)
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.2, minNeighbors=5)
    if len(faces) == 0:
        return None, None
    (x, y, w, h) = faces[0]
    return gray[y:y + h, x:x + h], faces[0]


def predict(test_img, faces, labels, face_recognizer):
    face_recognizer.train(faces, np.array(labels))
    img = test_img.copy()
    face, rect = detect_face(img)
    label, confidence = face_recognizer.predict(face)
    label_text = subject[label]
    draw_rectangle(img, rect)
    draw_text(img, label_text, rect[0], rect[1] - 5)
    return img


def main():
    print('データ準備....')
    faces, labels = prepare_training_data('ImageData')
    print('画像トタル', len(faces))
    print('ラベルトタル', len(labels))
    face_recognizer = cv2.face.LBPHFaceRecognizer_create()
    test_img = cv2.imread('ImageTesting/test2.jpg')
    predicted_img = predict(test_img, faces, labels, face_recognizer)
    cv2.imshow('結果...', cv2.resize(predicted_img, (400, 500)))
    cv2.waitKey(0)
    cv2.destroyAllWindows()
    cv2.waitKey(1)
    cv2.destroyAllWindows()


if __name__ == '__main__':
    main()
