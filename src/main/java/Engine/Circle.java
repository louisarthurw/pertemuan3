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

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float radiusX, float radiusY, int index) {
        super(shaderModuleDataList, vertices, color);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;

        if (index == 1) {
            createCircle();
        } else if (index == 2) {
            createKotak();
        } else if (index == 3) {
            createSegitiga();
        }

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

    public void draw() {
        drawSetup();
        //Bind IBO & draw
        glLineWidth(1);
        glPointSize(0);
//        glDrawArrays(GL_LINES, 0, vertices.size());
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }
}