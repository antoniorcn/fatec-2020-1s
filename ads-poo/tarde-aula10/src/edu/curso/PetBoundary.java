package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PetBoundary extends Application 
		implements EventHandler<ActionEvent>{
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtRaca = new TextField();
	private TextField txtPeso = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private PetControl control = new PetControl();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private TableView<Pet> table = new TableView<>();
	
	public void generateTable() { 
		TableColumn<Pet, Long> colId  = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Pet, Long>("id"));
		
		TableColumn<Pet, String> colNome  = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Pet, String>("nome"));
		
		TableColumn<Pet, String> colRaca  = new TableColumn<>("Raça");
		colRaca.setCellValueFactory(new PropertyValueFactory<Pet, String>("raca"));
		
		TableColumn<Pet, Double> colPeso  = new TableColumn<>("Peso");
		colPeso.setCellValueFactory(new PropertyValueFactory<Pet, Double>("peso"));
		
		TableColumn<Pet, String> colNascimento  = new TableColumn<>("Nascimento");
		colNascimento.setCellValueFactory(itemData -> { 
			return new ReadOnlyStringWrapper(
					dtf.format(itemData.getValue().getNascimento()));
		});
		
		table.getColumns().addAll(colId, colNome, colRaca, colPeso, colNascimento);
		table.setItems(control.getLista());
	}
	
	@Override
	public void start(Stage stage) { 
		BorderPane panePrincipal = new BorderPane();
		Scene scn = new Scene(panePrincipal, 400, 300);
		
		generateTable();
		
		GridPane paneCampos = new GridPane();
		
		panePrincipal.setTop(paneCampos);
		panePrincipal.setCenter(table);
		
		paneCampos.add(new Label("Id: "),  0, 0);
		paneCampos.add(txtId, 1, 0);
		paneCampos.add(new Label("Nome: "),  0, 1);
		paneCampos.add(txtNome, 1, 1);
		paneCampos.add(new Label("Raça: "),  0, 2);
		paneCampos.add(txtRaca, 1, 2);
		paneCampos.add(new Label("Peso: "),  0, 3);
		paneCampos.add(txtPeso, 1, 3);
		paneCampos.add(new Label("Nascimento: "),  0, 4);
		paneCampos.add(txtNascimento, 1, 4);
		paneCampos.add(btnAdicionar, 0, 5);
		paneCampos.add(btnPesquisar, 1, 5);
		
		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Pets");
		stage.show();
	}
	
	public void handle(ActionEvent evt) { 
		if (evt.getTarget() == btnAdicionar) { 
			Pet p = boundaryToEntity();
			control.adicionar(p);
		} else if (evt.getTarget() == btnPesquisar) { 
			Pet p = control.pesquisar(txtNome.getText());
			if (p != null) { 
				entityToBoundary(p);
			}
		}
	}
	
	public Pet boundaryToEntity() { 
		Pet p = new Pet();
		try { 
			p.setNome(txtNome.getText());
			p.setRaca(txtRaca.getText());
			p.setId(Long.parseLong(txtId.getText()));
			p.setPeso(Double.parseDouble(txtPeso.getText()));
			LocalDate dt = LocalDate.parse(txtNascimento.getText(), dtf);
			p.setNascimento(dt);		
		} catch (Exception e) { 
			System.out.println("Erro ao inputar os dados");
		}
		return p;
	}
	
	public void entityToBoundary(Pet p) { 
		txtNome.setText(p.getNome());
		txtRaca.setText(p.getRaca());
		txtId.setText( String.valueOf(p.getId()) );
		txtPeso.setText( String.valueOf(p.getPeso()) );
		txtNascimento.setText(dtf.format(p.getNascimento()));
	}
	
	public static void main(String[] args) {
		Application.launch(PetBoundary.class, args);
	}

}
