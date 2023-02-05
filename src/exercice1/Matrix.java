package exercice1;

import java.util.Scanner;

public class Matrix {
	// attributs
	private int row;
	private int column;
	private double[][] matrix;

	// constructeur sans parametre
	public Matrix() {
		super();
		// TODO Auto-generated constructor stub
		this.row = 2;
		this.column = 2;
		this.matrix = new double[2][2];
	}

	// constructeur avec parametre
	public Matrix(int row, int column, double[][] matrix) {
		super();
		this.row = row;
		this.column = column;
		this.matrix = matrix;
	}

	// constructeur avec deux parametres
	public Matrix(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	// getters and setters
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public double getCell(int i, int j) {
		return this.matrix[i][j];
	}

	public void setCell(int i, int j, double value) {
		this.matrix[i][j] = value;
	}

	//
	public void fillMatrix() {
		double[][] matrixToFill = new double[this.row][this.column];
		Scanner sc = new Scanner(System.in);

		try {
			for (int i = 0; i < this.row; i++) {
				for (int j = 0; j < this.column; j++) {
					System.out.printf("remplir la matrice avec des nombres : (%d,%d) ", i, j);
					matrixToFill[i][j] = sc.nextDouble();
				}
			}
			this.matrix = matrixToFill;
		} catch (Exception e) {
			throw new Error("erreur : veuillez rentrer des nombres réel : " + e.getMessage());
		}

	}

	//
	public void add(Matrix matrixToAdd) {

		if (this.getRow() != matrixToAdd.getRow()) {
			System.out.println("impossible de faire l'addition");
			return;
		}

		Matrix matrixResult = new Matrix(this.row, this.column);

		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				double sum = this.matrix[i][j] + matrixToAdd.getMatrix()[i][j];
				matrixResult.getMatrix()[i][j] = sum;
			}
		}

		String displayMatrix = "";

		System.out.println("le résultat de votre addition de matrix est : ----->>>>>>>>>>>");

		for (int i = 0; i < matrixResult.getRow(); i++) {
			for (int j = 0; j < matrixResult.getRow(); j++) {
				displayMatrix += String.valueOf(matrixResult.getCell(i, j)) + " ";
			}
			System.out.println("[ " + displayMatrix + "]");
			displayMatrix = "";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix A = new Matrix();
		A.fillMatrix();
		A.add(A);

	}

}
