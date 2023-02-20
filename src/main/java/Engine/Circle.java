package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Circle extends Object2d {
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public void createCircle() {
//        vertices -> clear
//        float degree = 45;
        float r = 0.03f;
        float xcenter = 0.1f;
        float ycenter = 0.1f;

        for (double i = 0; i < 360; i += 0.01f) {
            float x =  (float) (r * Math.cos(i) + xcenter);
            float y = (float) (r * Math.sin(i) + ycenter);
            vertices.add(new Vector3f(x, y, 0.0f));
        }

    }
}
