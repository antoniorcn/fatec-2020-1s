package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	private PetControl control = new PetControl();
	
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private ComboBox<String> cmbRaca = new ComboBox<>(control.getRacas());
	private TextField txtPeso = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	
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
		
		table.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Pet>() {
				@Override
				public void changed(ObservableValue<? extends Pet> value, Pet old, Pet novo) {
					entityToBoundary(novo);
				} 
			}
		);
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
		paneCampos.add(cmbRaca, 1, 2);
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
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Pet>> constraintViolations =
					  validator.validate( p );
			
			String msgErros =  "";
			for (ConstraintViolation<Pet> erro : constraintViolations) { 
				msgErros += erro.getPropertyPath() + " " + erro.getMessage() + "\n";
			}
			
			if (constraintViolations.isEmpty()) { 
				control.adicionar(p);
				entityToBoundary(new Pet());
				alertaMensagem(AlertType.INFORMATION, "Pet Shop", 
					null, String.format("O pet %s foi inserido com sucesso", p.getNome()));
			} else { 
				alertaMensagem(AlertType.ERROR, "Pet Shop", 
						"ERRO: Não é possível cadastrar o pet devido aos erros abaixo", msgErros);
			}
		} else if (evt.getTarget() == btnPesquisar) { 
			control.pesquisar(txtNome.getText());
		}
	}
	
	public void alertaMensagem(AlertType tipo, String titulo, String header, String msg) { 
		Alert alert = new Alert(tipo);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public Pet boundaryToEntity() { 
		Pet p = new Pet();
		try { 
			p.setNome(txtNome.getText());
			p.setRaca(cmbRaca.getSelectionModel().getSelectedItem());
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
		if (p != null) { 
			txtNome.setText(p.getNome());
			cmbRaca.getSelectionModel().select(p.getRaca());
			txtId.setText( String.valueOf(p.getId()) );
			txtPeso.setText( String.valueOf(p.getPeso()) );
			txtNascimento.setText(dtf.format(p.getNascimento()));
		}
	}
	
	public static void main(String[] args) {
		Application.launch(PetBoundary.class, args);
	}

}
