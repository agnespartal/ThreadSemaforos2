package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		Semaphore semaphore2 = new Semaphore(1);

		
		for (int id = 1; id < 6; id++) {
			Thread controller = new ThreadController(id, semaphore, semaphore2);
			controller.start();
		}
	}

}
