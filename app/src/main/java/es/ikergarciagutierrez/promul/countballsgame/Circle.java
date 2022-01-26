package es.ikergarciagutierrez.promul.countballsgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    /**
     * Campos de la clase
     */
    private Paint paint; // Objeto paint para dibujar el circulo

    private static final int RADIO = 100; // Radio del circulo

    private int centroX; // Posición en el eje X del círculo
    private int centroY; // Posición en el eje Y del círculo

    private int velocidadX = 50; // Velocidad en el eje X
    private int velocidadY = 50; // Velocidad en el eje Y

    /**
     * Constructor para el circulo
     *
     * @param context Contexto
     * @param attrs
     */
    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.RED);
    }

    /**
     * Cambiar tamaño de la pelota
     *
     * @param w    Ancho
     * @param h    Altura
     * @param oldW Antiguo ancho
     * @param oldH Antiguo alto
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        centroX = w / 2;
        centroY = h / 2;
    }

    /**
     * Dibujamos la pelota
     *
     * @param canvas Objeto canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        int w = getWidth();
        int h = getHeight();

        centroX += velocidadX;
        centroY += velocidadY;

        // Límites de pantalla
        int limiteDerecha = w - RADIO;
        int limiteInferior = h - RADIO;

        // Comprobar si invertir si llegamos al límite
        if (centroX >= limiteDerecha) {
            centroX = limiteDerecha;
            velocidadX *= -1;
        }
        if (centroX <= RADIO) {
            centroX = RADIO;
            velocidadX *= -1;
        }
        if (centroY >= limiteInferior) {
            centroY = limiteInferior;
            velocidadY *= -1;
        }
        if (centroY <= RADIO) {
            centroY = RADIO;
            velocidadY *= -1;
        }

        canvas.drawCircle(centroX, centroY, RADIO, paint);
        postInvalidateDelayed(100);

    }

}
