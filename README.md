PROgramadores
==

++ Subid las cosas puercos ++

Explicacion Fibonacci
--
¡Claro! Este código es como un cuento de hadas sobre un conejo mágico llamado Fibonacci. 🐇✨

Imagina que tienes una caja mágica que puede producir conejos. Al principio, la caja está vacía, así que decimos que hay `0` conejos. Luego, aparece un conejo mágico, así que ahora hay `1` conejo.

Aquí es donde las cosas se ponen interesantes. Cada conejo en la caja puede hacer un truco mágico: puede hacer aparecer exactamente tantos conejos como había en la caja justo antes de que él apareciera. Así que el primer conejo mira a la caja vacía y dice: "¡Presto!" Pero como no había conejos antes que él, no aparece ningún conejo nuevo.

Luego, ese mismo conejo hace su truco de nuevo. Esta vez, había `1` conejo en la caja antes que él (él mismo), así que aparece `1` conejo más. Ahora hay `2` conejos.

Cada uno de estos `2` conejos hace su truco mágico. Uno de ellos ve que había `1` conejo antes que él, así que hace aparecer `1` conejo más. El otro ve que había `2` conejos antes que él, así que hace aparecer `2` conejos más. Ahora hay `1 + 2 = 3` conejos.

Y así sucesivamente. Cada conejo hace aparecer tantos conejos como había justo antes de que él apareciera. Esto se llama la "sucesión de Fibonacci", y es lo que este código está calculando.

El código en sí mismo es como un libro de cuentos que sigue las aventuras de estos conejos mágicos. Cuando ejecutas el código, lees el número de casos (`nCasos`) y para cada caso, lees un número (`num`). Luego, calculas el `num`-ésimo número de Fibonacci (es decir, cuántos conejos hay después de que `num` conejos hayan hecho su truco mágico) y lo imprimes.

La función `fibonacci(num)` es la que realmente cuenta la historia de los conejos. Si `num` es `0` o `1`, simplemente devuelve `num` (porque al principio hay `0` conejos, y luego aparece `1`). Pero si `num` es `2` o más, entonces necesita averiguar cuántos conejos había antes (con `fibonacci(num-1)`) y cuántos conejos había antes de eso (con `fibonacci(num-2)`), y suma esos dos números para obtener el total de conejos.

Espero que esto te ayude a entender el código y la sucesión de Fibonacci. ¡Es una historia mágica de conejos que se multiplican! 🐇✨