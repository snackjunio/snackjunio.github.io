import cv2


def main():
    # OpenCVから顔と目をわかるようにライブラリを呼び出す(Path)
    face_path = r'opencv\sources\data\haarcascades_cuda\haarcascade_frontalface_default.xml'
    eye_path = r'opencv\sources\data\haarcascades_cuda\haarcascade_eye.xml'
    # ライブラリを呼び出してからcv2にimport
    face_in = cv2.CascadeClassifier(face_path)
    eye_in = cv2.CascadeClassifier(eye_path)
    # VideoCapture オブジェクトを取得します
    capture = cv2.VideoCapture(0)
    while True:
        # 実際のビデオ取得する
        ret, cam = capture.read()
        # 取得したビデオをGRAY色を変換する
        cam_gray = cv2.cvtColor(cam, cv2.COLOR_RGB2GRAY)
        # ビデオから顔と目を分別して取得する
        faces = face_in.detectMultiScale(cam_gray)
        for x, y, w, h in faces:
            cv2.rectangle(cam, (x, y), (x + w, y + h), (255, 0, 0), 2)
            face = cam[y: y + h, x: x + w]
            face_gray = cam_gray[y: y + h, x: x + w]
            # inputした写真から目を提供する
            eyes = eye_in.detectMultiScale(face_gray)
            for ex, ey, ew, eh in eyes:
                cv2.rectangle(face, (ex, ey), (ex + ew, ey + eh), (0, 255, 0), 2)
        # 顔と目を分別して取得してから表示する
        cv2.imshow('frame', cam)
        cv2.imwrite('dataset/cam.png', cam)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    capture.release()
    cv2.destroyAllWindows()


if __name__ == '__main__':
    main()
