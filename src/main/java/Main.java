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
    ArrayList<Sphere> objectsSphere = new ArrayList<>();

    boolean overlap;
    boolean isTouched;
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    boolean muter = false;
    float waktuMuter = 0.0f;

    public void init() {
        window.init();
        GL.createCapabilities();
//        camera.setPosition(0, 0, 0.5f);
        camera.setPosition(0, 0, 0.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));

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

//        objectsPointsControl.add(new Object2d(
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
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
//        ));

//        tugas bikin tata surya
//        matahari
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
                new Vector4f(0.984f, 0.627f, 0.059f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsSphere.get(0).scaleObject(0.45f, 0.45f, 0.45f);

        objectsSphere.get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.984f, 0.627f, 0.059f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.225f, 0.225f, 0.225f
        ));

        objectsSphere.get(0).getChildObject().get(0).translateObject(0.25f, 0.0f, 0.0f);

        objectsSphere.get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.984f, 0.627f, 0.059f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.225f, 0.225f, 0.225f
        ));

        objectsSphere.get(0).getChildObject().get(1).translateObject(0.5f, 0.0f, 0.0f);

        objectsSphere.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0.984f, 0.627f, 0.059f, 0.0f),
                0.0f, 0.0f, 0.0f, 0.225f, 0.225f, 0.225f));

        objectsSphere.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.5f);
        objectsSphere.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f, -0.2f, 0.0f);

        // object merah sebagai tumpuan
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
                new Vector4f(1.0f, 0, 0, 0),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
        ));
        objectsSphere.get(1).scaleObject(0.2f, 0.2f, 0.2f);
//        objectsSphere.get(1).translateObject(0.0f, 0.0f, 0.5f);
        objectsSphere.get(1).translateObject(0.75f, 0.0f, 0.0f);

//        // merkurius
//        objectsSphere.add(new Sphere(
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
//                new Vector4f(0.843f, 0.412f, 0.137f, 0.0f),
//                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
//        ));
//
//        //venus
//        objectsSphere.add(new Sphere(
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
//                new Vector4f(0.973f, 0.784f, 0.478f, 0.0f),
//                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
//        ));
//
//        //bumi
//        objectsSphere.add(new Sphere(
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
//                new Vector4f(0.514f, 0.792f, 0.976f, 0.0f),
//                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
//        ));
//
//        //bulan
//        objectsSphere.add(new Sphere(
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
//                new Vector4f(0.784f, 0.737f, 0.729f, 0.0f),
//                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
//        ));
//
//        //mars
//        objectsSphere.add(new Sphere(
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
//                new Vector4f(0.851f, 0.294f, 0.09f, 0.0f),
//                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f
//        ));
//
//        for (int i = 1; i < objectsSphere.size(); i++) {
//            if (i != 4) {
//                objectsSphere.get(i).scaleObject(0.1f, 0.1f, 0.1f);
//            } else {
//                objectsSphere.get(i).scaleObject(0.05f, 0.05f, 0.05f);
//            }
//
//            objectsSphere.get(i).setCenterX((float) (0.15 + (i * 0.15)));
//            objectsSphere.get(i).translateObject((float) (0.15 + (i * 0.15)), 0.0f, 0.0f);
//        }
    }

    public void input() {
        float move = 0.01f;

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveDown(move);
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveRight(move);
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveUp(move);
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveLeft(move);
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            camera.moveForward(move);
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            camera.moveBackwards(move);
        }

        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f displayVector = window.getMouseInput().getDisplVec();
            camera.addRotation((float) Math.toRadians(displayVector.x * 0.1f), (float) Math.toRadians(displayVector.y * 0.1f));
        }

        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y) * 0.1f);
            window.getMouseInput().setScroll(new Vector2f());
        }

        if (window.isKeyPressed(GLFW_KEY_T)) {
            camera.moveForward(move);
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {
            camera.moveBackwards(move);
        }

        if (window.isKeyPressed(GLFW_KEY_1)) {
            muter = true;
        }

        if (muter) {
            waktuMuter += 0.01f;
            camera.addRotation(0.0f, (float) Math.toRadians(0.5f));
        }

        if (waktuMuter >= 7.2f) {
            muter = false;
            waktuMuter = 0.0f;
        }

        // kamera gerak ke kanan, fokus ke object warna kuning
        if (window.isKeyPressed(GLFW_KEY_2)) {
            objectsSphere.get(0).translateObject(0.01f, 0.0f, 0.0f);
            camera.setPosition(camera.getPosition().x + 0.01f, camera.getPosition().y, camera.getPosition().z);
        }

        // kamera gerak ke kiri, fokus ke object warna kuning
        if (window.isKeyPressed(GLFW_KEY_3)) {
            objectsSphere.get(0).translateObject(-0.01f, 0.0f, 0.0f);
            camera.setPosition(camera.getPosition().x - 0.01f, camera.getPosition().y, camera.getPosition().z);
        }

        // kamera maju, fokus ke object warna kuning
        if (window.isKeyPressed(GLFW_KEY_4)) {
            objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.01f);
            camera.setPosition(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z + 0.01f);
        }

        // kamera mundur, fokus ke object warna kuning
        if (window.isKeyPressed(GLFW_KEY_5)) {
            objectsSphere.get(0).translateObject(0.0f, 0.0f, -0.01f);
            camera.setPosition(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z - 0.01f);
        }

        if (window.isKeyPressed(GLFW_KEY_6)) {
//            Vector3f target = objectsSphere.get(0).updateCenterPoint();
            Vector3f target = objectsSphere.get(0).getChildObject().get(0).updateCenterPoint();
            Vector3f sub = new Vector3f(camera.getPosition().x - target.x, camera.getPosition().y - target.y, camera.getPosition().z - target.z);

            camera.addRotation(0f, (float) Math.toRadians(-0.5f));
            float xnow = (float) ((sub.x * Math.cos(Math.toRadians(0.5f))) + (sub.z * Math.sin(Math.toRadians(0.5f))));
            float ynow = sub.y;
            float znow = (float) ((-sub.x * Math.sin(Math.toRadians(0.5f))) + (sub.z * Math.cos(Math.toRadians(0.5f))));
            camera.setPosition(xnow + target.x, ynow + target.y, znow + target.z);
        }

//        if (window.isKeyPressed(GLFW_KEY_W)) {
////            System.out.println("W");
////            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
//            objectsSphere.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//
//            for (Object2d child : objectsSphere.get(0).getChildObject()) {
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//
//            for (Object2d child : objectsSphere.get(0).getChildObject().get(1).getChildObject()) {
//                Vector3f tempCenterPoint = objectsSphere.get(0).getChildObject().get(1).updateCenterPoint();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject(0.05f, 0.0f, 0.0f, 1.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//        }

//        if (window.isKeyPressed(GLFW_KEY_F)) {
//            for (int i = 1; i < objectsSphere.size(); i++) {
//                objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//                objectsSphere.get(i).setCenterX((float) (objectsSphere.get(i).getCenterX() * Math.cos(Math.toRadians(0.5f)) - objectsSphere.get(i).getCenterY() * Math.sin(Math.toRadians(0.5f))));
//                objectsSphere.get(i).setCenterY((float) (objectsSphere.get(i).getCenterX() * Math.sin(Math.toRadians(0.5f)) + objectsSphere.get(i).getCenterY() * Math.cos(Math.toRadians(0.5f))));
//            }
//        }

//        if (window.isKeyPressed(GLFW_KEY_G)) {
//            for (int i = 1; i < objectsSphere.size(); i++) {
//                float x = objectsSphere.get(i).getCenterX();
//                float y = objectsSphere.get(i).getCenterY();
//                float z = objectsSphere.get(i).getCenterZ();
//
//                objectsSphere.get(i).translateObject(-x, -y, -z);
//                if (i != 4) {
//                    objectsSphere.get(i).rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
//                }
//                objectsSphere.get(i).translateObject(x, y, z);
//            }
//        }

//        if (window.isKeyPressed(GLFW_KEY_H)) {
//            float x = objectsSphere.get(3).getCenterX();
//            float y = objectsSphere.get(3).getCenterY();
//            float z = objectsSphere.get(3).getCenterZ();
//
//            objectsSphere.get(4).translateObject(-x, -y, -z);
//            objectsSphere.get(4).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
//            objectsSphere.get(4).translateObject(x, y, z);
//        }

//        if (window.getMouseInput().isLeftButtonPressed()) {
//            Vector2f pos = window.getMouseInput().getCurrentPos();
////            System.out.println("x : "+pos.x+" y : "+pos.y);
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
////            System.out.println("x : "+pos.x+" y : "+pos.y);
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);
//                overlap = false;
//                int index = 0;
//
//                for (Circle object : objectsRectangle2) {
//                    overlap = object.isOverlap(pos.x, pos.y);
//                    if (overlap) {
//                        break;
//                    }
//                }
//
//                for (Circle object : objectsRectangle2) {
//                    isTouched = object.isTouched(pos.x, pos.y);
//                    if (isTouched) {
//                        objectsPointsControl.get(0).update(index, new Vector3f(pos.x, pos.y, 0));
//                        object.moveKotak(pos.x, pos.y, 0.05f);
//                    }
//                    index++;
//                }
//
//                if (!overlap) {
//                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                    objectsRectangle2.add(new Circle(
//                            Arrays.asList(
//                                    //shaderFile lokasi menyesuaikan objectnya
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.vert"
//                                                    , GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/scene.frag"
//                                                    , GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(),
//                            new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                            pos.x, pos.y, 0.05f, 0.05f, 2
//                    ));
//                }
//            }
//        }
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

            for (Sphere object : objectsSphere) {
                object.draw(camera, projection);
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