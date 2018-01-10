package simonGame;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextBox;
import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class GameScreen extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button redButton;
	private Button yellowButton;
	private Button greenButton;
	private Button cyanButton;
	private Button pinkButton;
	private Button orangeButton;
	
	
	private TextBox gameMetaText;
	
	private long sequenceSpeed = 1000;
	
	boolean firstUpdate = true;
	
	boolean simonsTurn = true;
	
	
	int seqPos = 0;
	String[] currentRound;

	public GameScreen(int width, int height) {
		super(width, height);
		
	}
	
	public void buttonClick(String color) {
		System.out.println("simonsTurn is " + simonsTurn);
		if(simonsTurn == false) {
			if(this.currentRound[this.seqPos] == color) {
				this.seqPos++;
			}
			else {
				System.out.println("end game");
			}
			
			if(this.seqPos == this.currentRound.length) {
				simonsTurn = true;
				
				setUpNextRound();
				displayCurrentRound();
			}
		}
		

	}
	
	
	public void setUpNextRound() {
		String[] nextRound = new String[this.currentRound.length+1];
		System.arraycopy( this.currentRound, 0, nextRound, 0, this.currentRound.length );
		
		if(nextRound.length >= 2) {
			nextRound[nextRound.length-1] = getRandMove(nextRound[nextRound.length-2]);
		}else
		{
			nextRound[nextRound.length-1] = getRandMove("None");
		}
		
		
		
		this.currentRound = nextRound;
		
		this.gameMetaText.remove(0, gameMetaText.getText().length());
		this.gameMetaText.setText(getRoundText());
		this.gameMetaText.update();

		this.seqPos = 0;
		
		
		simonTurn();
		
		
	}
	
	public void simonTurn() {
		Thread simonButtonSeq = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//wait for previous moves to complete toggling buttons
				
				for(int i = 0; i < currentRound.length; i++) {
					toggleButton(currentRound[i]);
					System.out.println("button " + i +" toggled");
					
				}
				simonsTurn = false;
			}
		});
	simonButtonSeq.start();
	if(sequenceSpeed >= 100) {
		sequenceSpeed -= 50;
	}
	}
	
	public void displayCurrentRound() {
		System.out.println("current round:");
		for(String s : this.currentRound) {
			System.out.println(s);		
		}
		
		
		
		
	}
	
	public void toggleButton(String s) {
		switch(s) {
		case "red":
			redButton.setBackground(Color.WHITE);
			redButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			redButton.setBackground(Color.RED);
			redButton.update();
			break;
			
		case "yellow":
			yellowButton.setBackground(Color.WHITE);
			yellowButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			yellowButton.setBackground(Color.YELLOW);
			yellowButton.update();
			break;
		case "green":
			greenButton.setBackground(Color.WHITE);
			greenButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			greenButton.setBackground(Color.GREEN);
			greenButton.update();
		
			break;
			
		case "pink":
			pinkButton.setBackground(Color.WHITE);
			pinkButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pinkButton.setBackground(Color.PINK);
			pinkButton.update();
			break;
		case "orange":
			orangeButton.setBackground(Color.WHITE);
			orangeButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			orangeButton.setBackground(Color.ORANGE);
			orangeButton.update();
			break;
			
		case "cyan":
			cyanButton.setBackground(Color.WHITE);
			cyanButton.update();
			
			try {
				Thread.sleep(sequenceSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cyanButton.setBackground(Color.CYAN);
			cyanButton.update();
			break;
	
	}
	}

	public void fillArrayWithMoves(String[] arr) {
		if(arr.length > 0) {
			arr[0] = getRandMove("None");
		}
		for(int i = 1; i < arr.length; i++) {
			arr[i] = getRandMove(arr[i-1]);
		}
	}
	
	public String getRandMove(String prevColor) {
		while(true) {
			
			int randNum = (int)(Math.random() * 6);
			
			switch (randNum){
			case 0:
				if(prevColor != "red") {
					return "red";
				}
				
			case 1:
				if(prevColor != "yellow") {
					return "yellow";
				}
				
			case 2:
				if(prevColor != "green") {
					return "green";
				}
				
			case 3:
				if(prevColor != "pink") {
					return "pink";
				}
				
			case 4:
				if(prevColor != "orange") {
					return "orange";
				}
			case 5:
				if(prevColor != "cyan") {
					return "cyan";
			}
		}
		}
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//initialize first round
		
		currentRound = new String[3];
		fillArrayWithMoves(currentRound);
		
		redButton = new Button(300, 100 ,50,50, "",Color.RED, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						redButton.setBackground(Color.WHITE);
						redButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						redButton.setBackground(Color.RED);
						redButton.update();
					}
				});
			blinker.start();
			buttonClick("red");
		
			}
		} );
		
		redButton.setCurve(50, 50);
		viewObjects.add(redButton);
		
		
		yellowButton = new Button(250, 150 ,50,50, "",Color.YELLOW, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						yellowButton.setBackground(Color.WHITE);
						yellowButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						yellowButton.setBackground(Color.YELLOW);
						yellowButton.update();
					}
				});
			blinker.start();
			buttonClick("yellow");
			
			}
		} );
		
		yellowButton.setCurve(50, 50);
		viewObjects.add(yellowButton);
		
		
		
		greenButton = new Button(250, 220 ,50,50, "",Color.GREEN, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						greenButton.setBackground(Color.WHITE);
						greenButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						greenButton.setBackground(Color.GREEN);
						greenButton.update();
					}
				});
			blinker.start();
			buttonClick("green");
			
			}
		} );
		
		greenButton.setCurve(50, 50);
		viewObjects.add(greenButton);
		
		
		
		cyanButton = new Button(300, 265 ,50,50, "",Color.CYAN, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						cyanButton.setBackground(Color.WHITE);
						cyanButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						cyanButton.setBackground(Color.CYAN);
						cyanButton.update();
					}
				});
			blinker.start();
			buttonClick("cyan");
			
			}
		} );
		
		cyanButton.setCurve(50, 50);
		viewObjects.add(cyanButton);
		
		
		
		pinkButton = new Button(350, 220 ,50,50, "",Color.PINK, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						pinkButton.setBackground(Color.WHITE);
						pinkButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pinkButton.setBackground(Color.PINK);
						pinkButton.update();
					}
				});
			blinker.start();
			buttonClick("pink");
			
			}
		} );
		
		pinkButton.setCurve(50, 50);
		viewObjects.add(pinkButton);
		
		orangeButton = new Button(350, 150 ,50,50, "",Color.ORANGE, new Action() {
			
			@Override
			public void act() {
				Thread blinker = new Thread(new Runnable() {
					
					@Override
					public void run() {
						
						orangeButton.setBackground(Color.WHITE);
						orangeButton.update();
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						orangeButton.setBackground(Color.ORANGE);
						orangeButton.update();
					}
				});
			blinker.start();
			buttonClick("orange");
			
			}
		} );
		
		orangeButton.setCurve(50, 50);
		viewObjects.add(orangeButton);
		
		
		
		gameMetaText = new TextBox(300,350,175,60, getRoundText());
		viewObjects.add(gameMetaText);
		
	}
	
	
	public String getRoundText() {
		return "Round " + (this.currentRound.length - 2) + "\nSequence Length: "+this.currentRound.length;
	}
	
	public void update() {
		if(this.firstUpdate) {
			System.out.println("firstUPdate");
			this.firstUpdate = false;
			this.displayCurrentRound();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.simonTurn();
		}
		super.update();
	}
}
