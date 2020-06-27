<html>
    <head>
        <link rel="stylesheet" href="./css/bootstrap.min.css"/>
        <meta charset="utf-8"/>
    </head>

    <body>
        <div class="container">
            <h1>Cadastro de Pets</h1>
            <?php
                session_start();
                if (isset($_SESSION['MENSAGEM'])) { 
            ?>
                <div class="alert alert-success" role="alert">
                    <?=$_SESSION['MENSAGEM']?>
                </div>
            <?php
                    unset($_SESSION['MENSAGEM']);
                }
            ?>
            <form action="./petController.php">
                <div class="form-group">
                    <label>Nome</label>
                    <input type="text" class="form-control" name="NOME"/>
                </div>
                <div class="form-group">
                    <label>Raça</label>
                    <select class="form-control" name="RACA">
                        <option value="vira-lata">Vira Lata</option>
                        <option value="bulldog">Bull Dog</option>
                        <option value="pastor-alemao">Pastor Alemão</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Peso</label>
                    <input type="number" step="0.1" class="form-control" name="PESO"/>
                </div>
                <div class="form-group">
                    <label>Nascimento</label>
                    <input type="date" pattern="dd/MM/yyyy" class="form-control" name="NASC"/>
                </div>
                <div class="form-group">
                    <button type="submit" name="CMD" value="adicionar" class="btn btn-primary">Adicionar</button>
                    <button type="submit" name="CMD" value="pesquisar" class="btn btn-primary">Pesquisar</button>
                </div>
            </form>

            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Raça</th>
                        <th>Peso</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                        if (isset($_SESSION['LISTA'])) { 
                            foreach($_SESSION['LISTA'] as $pet) {
                    ?>
                                <tr>
                                    <td><?=$pet['nome']?></td>
                                    <td><?=$pet['raca']?></td>
                                    <td><?=$pet['peso']?></td>
                                </tr>
                    <?php
                            } 
                        } ?>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="./js/bootstrap.min.js"></script>
    </body>
</html>