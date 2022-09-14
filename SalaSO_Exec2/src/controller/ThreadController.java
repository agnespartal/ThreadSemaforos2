package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	private int id;
	private Semaphore semaforo;
	private Semaphore semaforo2;

	public ThreadController(int id, Semaphore semaforo, Semaphore semaforo2) {
		super();
		this.id = id;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;

	}

	@Override
	public void run() {
		cozinha();
		entrega();
	}

	private void cozinha() {
		double tempoImpar = ((Math.random() * 0.31) + 0.5);
		double tempoPar = ((Math.random() * 0.61) + 0.6);
		double percentual1 = 0.0;
		double percentual2 = 0.0;

		if (id % 2 == 1) {
			System.out.println("Sopa de Cebola iniciou");

			while (percentual1 < 99.9) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tempoImpar = tempoImpar - 0.1;
				percentual1 = (0.1 / tempoImpar) * 100;
				if (percentual1 > 100) {
					System.out.println("Cozinhando Sopa de cebola: 100%");
				} else {
					System.out.println("Cozinhando Sopa de cebola:" + (int)percentual1 + "%");
				}
			}
			System.out.println("Sopa de cebola pronta");

		} else {
			System.out.println("Lasanha a Bolonhesa iniciou");

			while (percentual2 < 99.9) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tempoPar = tempoPar - 0.1;
				percentual2 = (0.1 / tempoPar) * 100;
				if (percentual2 > 100) {
					System.out.println("Cozinhando Lasanha a Bolonhesa: 100%");
				} else {
					System.out.println("Cozinhando Lasanha a Bolonhesa:" + (int)percentual2 + "%");
				}
			}
			System.out.println("Lasanha a Bolonhesa pronta");
		}

	}

	private void entrega() {

		if (id % 2 == 1) {
			try {
				semaforo.acquire();
				System.out.println("Sopa de cebola está sendo entregue");
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
				System.out.println("Sopa de cebola entregue");
			}

		} else {
			try {
				semaforo2.acquire();
				System.out.println("Lasanha a Bolonhesa está sendo entregue");
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
				System.out.println("Lasanha a Bolonhesa entregue");
			}
		}
	}
}
