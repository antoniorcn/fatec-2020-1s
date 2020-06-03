<html>
    <body>
        <h1>Arquivo em PHP</h1>
        <p>Isto vai aparecer no navegador</p>
        <?php
            $a = 10;
            $b = $a * 15;
            echo "<p>Variavel B: \\ \" \$b</p>";
            if ($b > 100) { 
        ?>
                <p>Variável B é maior que 100</p>
        <?php
            } else { 
        ?>
                <p>Variável B não é maior que 100</p>
        <?php
            }
        ?>
            <!-- Comentario de HTML -->
        <?php
            // Comentário
            /* Comentario de 
            varias 
            linhas 
            */
            for ($i=0; $i < 20; $i++) { 
        ?>
                <p><?=$i?></p>
        <?php
            }
        ?>
    </body>
</html>