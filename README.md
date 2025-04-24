# Testing

Mejoras a realizar.

Mejora en la claridad del ccódigo (Comentarios y mayor división en clases {Gusto personal})
Pasó todas las pruebas de testing, pero encontré yo por mi cuenta los siguientes errores.

La banca roba un céntimo, es decir si ingresas 200, y tienes un gasto de 199.99, al mostrar dinero no muestra 0.01, sino 0.00
También, puedes acabar en un bucle infinito si intentas restar dinero, pero no tienes dinero metido, por que 0 no se considera restar.
