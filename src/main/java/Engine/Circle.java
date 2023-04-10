package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object2d {
    float centerX;
    float centerY;
    float radiusX;
    float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float radiusX, float radiusY, int mode) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;

        if (mode == 1) {
            createCircle();
        } else if (mode == 2) {
            createKotak();
        } else if (mode == 3) {
            createSegitiga();
        }

        setupVAOVBO();
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float radiusX, float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createCircle();
        setupVAOVBO();
    }

    public void createCircle() {
//        vertices -> clear
        vertices.clear();

        for (double i = 0; i < 360; i += 0.01f) {
            float x = (float) (radiusX * Math.cos(i) + centerX);
            float y = (float) (radiusY * Math.sin(i) + centerY);
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    //  persegi pakai rumus lingkaran
    public void createKotak() {
//        vertices -> clear
        vertices.clear();

        for (double i = 45; i <= 360; i += 90) {
            float x = (float) (radiusX * Math.cos(Math.toRadians(i)) + centerX);
            float y = (float) (radiusY * Math.sin(Math.toRadians(i)) + centerY);
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    //    segitiga pakai rumus lingkaran
    public void createSegitiga() {
//        vertices -> clear
        vertices.clear();

        for (double i = -30; i < 360; i += 120) {
            float x = (float) (radiusX * Math.cos(Math.toRadians(i)) + centerX);
            float y = (float) (radiusY * Math.sin(Math.toRadians(i)) + centerY);
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

//    public void draw() {
//        drawSetup();
//        //Bind IBO & draw
//        glLineWidth(1);
//        glPointSize(0);
////        glDrawArrays(GL_LINES, 0, vertices.size());
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
////        glDrawArrays(GL_POLYGON, 0, vertices.size());
//    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public float getRadiusX() {
        return radiusX;
    }

    public boolean isOverlap(float x, float y) {
        float jarak = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return jarak <= 2 * this.radiusX;
    }

    public boolean isTouched(float x, float y) {
        float jarak = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return jarak <= this.radiusX;
    }

    public void moveKotak(float x, float y, float radius) {
        this.centerX = x;
        this.centerY = y;
        this.radiusX = radius;
        this.radiusY = radius;
        createKotak();
        setupVAOVBO();
    }

    public void update(int index, Vector3f newVector) {

    }
}