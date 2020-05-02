import cv2
def main():
    # OpenCVから顔と目をわかるようにライブラリを呼び出す(Path)
    face_path = r'opencv\haarcascade_frontalface_default.xml'
    eye_path = r'opencv\haarcascade_eye.xml'
    # ライブラリを呼び出してからcv2にimport
    face_in = cv2.CascadeClassifier(face_path)
    eye_in = cv2.CascadeClassifier(eye_path)
    # 写真をinputする
    src = cv2.imread('dataset/nako.png')
    # gray色をconvertする
    src_gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
    # inputした写真から顔を摘出する
    faces = face_in.detectMultiScale(src_gray)
    for x, y, w, h in faces:
        cv2.rectangle(src, (x, y), (x + w, y + h), (255, 0, 0), 2)
        face = src[y: y + h, x: x + w]
        face_gray = src_gray[y: y + h, x: x + w]
        # inputした写真から目を提供する
        eyes = eye_in.detectMultiScale(face_gray)
        for ex, ey, ew, eh in eyes:
            cv2.rectangle(face, (ex, ey), (ex + ew, ey + eh), (0, 255, 0), 2)
    # 提供した顔と目は新しい写真を作成する
    cv2.imwrite('dataset/nako2.png', src)


if __name__ == '__main__':
    main()