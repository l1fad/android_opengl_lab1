package ivanovbugs.example.opengl_lab1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Square {
    float[] a = new float[]{
            -1, 1, 0,
            -1, -1, 0,
            1, -1, 0,
            1, 1, 0
    };
    float[] c = new float[]{
            1, 1, 0, 1,
            1, 0, 1, 1,
            0, 1, 1, 1,
            0, 1, 0, 1
    };
    FloatBuffer f, col;
    ByteBuffer b;

    public Square() {
        b=ByteBuffer.allocateDirect(4*3*4);
        b.order(ByteOrder.nativeOrder());
        f=b.asFloatBuffer();
        f.put(a);
        f.position(0);
        b=ByteBuffer.allocateDirect(4*4*4);
        b.order(ByteOrder.nativeOrder());
        col=b.asFloatBuffer();
        col.put(c);
        col.position(0);
    }

    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,f);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4,GL10.GL_FLOAT,0,col);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

    }
}
