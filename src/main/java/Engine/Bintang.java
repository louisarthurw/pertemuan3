package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Bintang extends Object2d{
    List<Integer> index;
    int ibo;
    float centerX;
    float centerY;
    float radius;

    public Bintang(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index, float centerX, float centerY, float radius) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index),
                GL_STATIC_DRAW);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

        createStar();
        setupVAOVBO();
    }

    public void createStar() {
//        vertices -> clear
        vertices.clear();

        for (double i = -36; i < 360; i += 72) {
            float x = (float) (radius * Math.cos(Math.toRadians(i)) + centerX);
            float y = (float) (radius * Math.sin(Math.toRadians(i)) + centerY);
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public void draw() {
        drawSetup();
        //Bind IBO & draw
        glLineWidth(2);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_LINES, index.size(), GL_UNSIGNED_INT, 0);
    }
}
