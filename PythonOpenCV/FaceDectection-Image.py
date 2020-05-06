import cv2


def main():
    # OpenCVから顔と目をわかるようにライブラリを呼び出す(Path)
    face_path = r'opencv/haarcascade_frontalface_default.xml'
    # ライブラリを呼び出してからcv2にimport
    face_in = cv2.CascadeClassifier(face_path)
    # 写真をinputする
    src = cv2.imread(r'ImageTesting\test2.jpg')
    # gray色をconvertする
    src_gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
    # inputした写真から顔を摘出する
    faces = face_in.detectMultiScale(src_gray, scaleFactor=1.2, minNeighbors=5)
    for x, y, w, h in faces:
        cv2.rectangle(src, (x, y), (x + w, y + h), (0, 255, 0), 2)
        # inputした写真から目を提供する
    # 提供した顔と目は新しい写真を作成する
    print(faces)
    cv2.imshow('data', cv2.resize(src, (400, 500)))
    cv2.waitKey(1500)
    # cv2.imwrite('ImageData/s2/4.png', src)
    cv2.destroyAllWindows()
    cv2.waitKey(1)


if __name__ == '__main__':
    main()
