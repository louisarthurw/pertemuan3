package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Circle {
    float centerZ;
    float radiusZ;
    List<Integer> index;
    int ibo;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ, int mode) {
        super(shaderModuleDataList, vertices, color, centerX, centerY, radiusX, radiusY, mode);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
        createBox();
        setupVAOVBO();
    }

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY, float centerZ, float radiusX, float radiusY, float radiusZ) {
        super(shaderModuleDataList, vertices, color, centerX, centerY, radiusX, radiusY);
        this.centerZ = centerZ;
        this.radiusZ = radiusZ;
//        createSphere();
        createBox();
//        createEllipsoid();
//        createHyperboloid_1_Side();
//        createHyperboloid_2_Side();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();
        setupVAOVBO();
    }

    public void createBox() {
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        // Titik 1 kiri atas belakang
        temp.x = centerX - radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 2 kiri bawah belakang
        temp.x = centerX - radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 3 kanan bawah belakang
        temp.x = centerX + radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 4 kanan atas belakang
        temp.x = centerX + radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 5 kiri atas depan
        temp.x = centerX - radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 6 kiri bawah depan
        temp.x = centerX - radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 7 kanan bawah depan
        temp.x = centerX + radiusX / 2;
        temp.y = centerY - radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 8 kanan atas depan
        temp.x = centerX + radiusX / 2;
        temp.y = centerY + radiusY / 2;
        temp.z = centerZ + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // Kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        // Kotak samping kiri
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));

        // Kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        // Kotak atas
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));

        // Kotak bawah
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
    }

    public void createSphere() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x, y, z, xy, nx, ny, nz;
        float sectorStep = (float) (2 * Math.PI) / sectorCount; //sector count
        float stackStep = (float) Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for (int i = 0; i <= stackCount; i++) {
            stackAngle = (float) Math.PI / 2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for (int j = 0; j < sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for (int j = 0; j < sectorCount; ++j, ++k1, ++k2) {
                if (i != 0) {
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
                if (i != (18 - 1)) {
                    temp_indices.add(k1 + 1);
                    temp_indices.add(k2);
                    temp_indices.add(k2 + 1);
                }
            }
        }

        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void createEllipsoid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.5f * (float) (Math.cos(v) * Math.cos(u));
                float y = 0.3f * (float) (Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }
    public void createHyperboloid_1_Side() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.1f * (float) (1/Math.cos(v)) *  (float) Math.cos(u);
                float z = 0.1f * (float) (1/Math.cos(v)) * (float) Math.sin(u);
                float y = 0.1f * (float) (Math.tan(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid_2_Side() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI/2; u <= Math.PI/2; u += Math.PI / 16) {
                float x = 0.1f * (float) (Math.tan(v)) *  (float) Math.cos(u);
                float z = 0.1f * (float) (Math.tan(v)) * (float) Math.sin(u);
                float y = 0.1f * (float) (1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 36) {
            for (double u = Math.PI/2; u <= 3*Math.PI/2; u += Math.PI / 26) {
                float x = 0.1f * (float) (Math.tan(v)) *  (float) Math.cos(u);
                float z = 0.1f * (float) (Math.tan(v)) * (float) Math.sin(u);
                float y = -0.1f * (float) (1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }

    public void createEllipticCone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.1f * (float) v *  (float) Math.cos(u);
                float z = 0.1f * (float) v * (float) Math.sin(u);
                float y = 0.1f * (float) v;
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createEllipticParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 3; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.5f * (float) v *  (float) Math.cos(u);
                float z = 0.5f * (float) v * (float) Math.sin(u);
                float y = (float) Math.pow(v, 2);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 3; v += Math.PI / 16) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 16) {
                float x = 0.1f * (float) v *  (float) Math.tan(u);
                float z = 0.1f * (float) v * (float) (1/Math.cos(u));
                float y = (float) Math.pow(v, 2);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void drawIndices() {
        drawSetup();
        //Bind IBO & draw
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_LINE_STRIP, index.size(), GL_UNSIGNED_INT, 0);
    }

    @Override
    public float getCenterX() {
        return super.getCenterX();
    }

    @Override
    public float getCenterY() {
        return super.getCenterY();
    }

    public float getCenterZ() {
        return centerZ;
    }
    public void setCenterZ(float centerZ) {
        this.centerZ = centerZ;
    }
}