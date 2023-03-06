import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800, 800, "Window");

    ArrayList<Object2d> objects = new ArrayList<>();
    ArrayList<Object2d> objectsRectangle = new ArrayList<>();
    ArrayList<Object2d> objectsCircle = new ArrayList<>();
    ArrayList<Object2d> objectsStar = new ArrayList<>();
    ArrayList<Object2d> objectsPointsControl = new ArrayList<>();
    ArrayList<Circle> objectsRectangle2 = new ArrayList<>();

    ArrayList<Object2d> objectsCurve = new ArrayList<>();
    ArrayList<Object2d> objectsSphere = new ArrayList<>();

    boolean overlap;
    boolean isTouched;

    public void init() {
        window.init();
        GL.createCapabilities();

//        code
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(-0.5f, -0.5f, 0.0f),
//                                new Vector3f(0.5f, -0.5f, 0.0f)
//                        )
//                ), new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
//        ));

//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(-0.5f, -0.5f, 0.0f),
//                                new Vector3f(0.5f, -0.5f, 0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f, 0.0f, 0.0f),
//                                new Vector3f(0.0f, 1.0f, 0.0f),
//                                new Vector3f(0.0f, 0.0f, 1.0f)
//                        )
//                )
//        ));

//        pr pertemuan 2 bikin rumah
//        //background langit biru
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f, 1.0f, 0.0f),
//                                new Vector3f(1.0f, 1.0f, 0.0f),
//                                new Vector3f(-1.0f, -0.6f, 0.0f),
//                                new Vector3f(1.0f, -0.6f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.2f, 0.196f, 0.898f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // background rumput
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f, -0.6f, 0.0f),
//                                new Vector3f(1.0f, -0.6f, 0.0f),
//                                new Vector3f(-1.0f, -1.0f, 0.0f),
//                                new Vector3f(1.0f, -1.0f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.0f, 0.502f, 0.004f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // segitiga merah
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f, 0.2f, 0.0f),
//                                new Vector3f(-0.8f, -0.2f, 0.0f),
//                                new Vector3f(-0.2f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2)
//        ));
//
//        // kotak coklat
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.65f, -0.12f, 0.0f),
//                                new Vector3f(0.65f, -0.12f, 0.0f),
//                                new Vector3f(-0.65f, -0.69f, 0.0f),
//                                new Vector3f(0.65f, -0.69f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.694f, 0.502f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // segitiga coklat
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.47f, 0.12f, 0.0f),
//                                new Vector3f(-0.65f, -0.12f, 0.0f),
//                                new Vector3f(-0.29f, -0.12f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.694f, 0.502f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2)
//        ));
//
//        // jajargenjang merah
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f, 0.2f, 0.0f),
//                                new Vector3f(0.5f, 0.2f, 0.0f),
//                                new Vector3f(-0.235f, -0.2f, 0.0f),
//                                new Vector3f(0.8f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // cerobong coklat
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.3f, 0.3f, 0.0f),
//                                new Vector3f(0.4f, 0.3f, 0.0f),
//                                new Vector3f(0.3f, 0.1f, 0.0f),
//                                new Vector3f(0.4f, 0.1f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.694f, 0.502f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // cerobong coklat tua
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.268f, 0.343f, 0.0f),
//                                new Vector3f(0.43f, 0.343f, 0.0f),
//                                new Vector3f(0.268f, 0.3f, 0.0f),
//                                new Vector3f(0.43f, 0.3f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.698f, 0.2f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//
//        // lingkaran kuning
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 0.996f, 0.004f, 0.0f),
//                -0.7f, 0.75f, 0.1f, 0.1f, 1
//        ));
//
//        // lingkaran biru
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.2f, 0.196f, 0.898f, 0.0f),
//                -0.65f, 0.75f, 0.1f, 0.1f, 1
//        ));
//
//        // bintang 1
//        objectsStar.add(new Bintang(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                Arrays.asList(4, 1, 1, 3, 3, 0, 0, 2, 2, 4),
//                -0.28f, 0.57f, 0.045f
//        ));
//
//        // bintang 2
//        objectsStar.add(new Bintang(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                Arrays.asList(4, 1, 1, 3, 3, 0, 0, 2, 2, 4),
//                -0.02f, 0.86f, 0.02f
//        ));
//
//        // bintang 3
//        objectsStar.add(new Bintang(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                Arrays.asList(4, 1, 1, 3, 3, 0, 0, 2, 2, 4),
//                0.75f, 0.73f, 0.052f
//        ));
//
//        // asap bawah
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                0.35f, 0.42f, 0.07f, 0.04f, 1
//        ));
//
//        // asap tengah
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                0.393f, 0.469f, 0.08f, 0.042f, 1
//        ));
//
//        // asap atas
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.502f, 0.502f, 0.502f, 0.0f),
//                0.47f, 0.52f, 0.12f, 0.04f, 1
//        ));

        objectsPointsControl.add(new Object2d(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
        ));

        objectsSphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");
        }

        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println("x : " + pos.x + " y : " + pos.y);
                overlap = false;
                int index = 0;

                for (Circle object : objectsRectangle2) {
                    overlap = object.isOverlap(pos.x, pos.y);
                    if (overlap) {
                        break;
                    }
                }

                for (Circle object : objectsRectangle2) {
                    isTouched = object.isTouched(pos.x, pos.y);
                    if (isTouched) {
                        objectsPointsControl.get(0).update(index, new Vector3f(pos.x, pos.y, 0));
                        object.moveKotak(pos.x, pos.y, 0.05f);
                    }
                    index++;
                }

                if (!overlap) {
                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
                    objectsRectangle2.add(new Circle(
                            Arrays.asList(
                                    //shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.vert"
                                                    , GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.frag"
                                                    , GL_FRAGMENT_SHADER)
                            ),
                            new ArrayList<>(),
                            new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                            pos.x, pos.y, 0.05f, 0.05f, 2
                    ));
                }
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
            input();

            //code
            for (Object2d object : objects) {
                object.drawWithVerticesColor();
            }

            for (Object2d object : objectsRectangle) {
                object.draw();
            }

            for (Object2d object : objectsCircle) {
                object.draw();
            }

            for (Object2d object : objectsStar) {
                object.draw();
            }

            for (Object2d object : objectsPointsControl) {
                object.drawLine();
            }

            ArrayList<Object2d> objectsCurve = calculatePoint(objectsRectangle2);
            for (Object2d object : objectsCurve) {
                object.drawLine();
            }

            for (Circle object : objectsRectangle2) {
                object.draw();
            }

            for (Object2d object : objectsSphere) {
                object.draw();
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public static ArrayList<Object2d> calculatePoint(ArrayList<Circle> arr) {
        int n = arr.size() - 1;
        ArrayList<Object2d> objectsCurve = new ArrayList<>();

        objectsCurve.add(new Object2d(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.6f, 0.929f, 0.765f, 1.0f)
        ));

        for (float j = 0; j <= 1; j += 0.01f) {
            float x = 0;
            float y = 0;
            for (int i = 0; i <= n; i++) {
                double factor = combination(n, i) * Math.pow(1 - j, n - i) * Math.pow(j, i);
                x += factor * arr.get(i).getCenterX();
                y += factor * arr.get(i).getCenterY();
            }
            objectsCurve.get(0).addVertices((new Vector3f(x, y, 0)));
        }

        return objectsCurve;
    }

    public static int combination(int n, int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - i + 1;
            result /= i;
        }
        return result;
    }

    public void run() {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}