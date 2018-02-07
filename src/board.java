import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class board extends Applet implements MouseListener,KeyListener {
	
	private int xpos, ypos,c=0,x3,y3,x,y,tx,ty,l=0,m=0,x2,y2,wc,bc,n=0;
	private int[][] board;
	private String piece,o;  
	private String[][] pieces, zen;
	private Image brook, bknight, bbishop, bking, bqueen, bpawn, wrook, wknight, wbishop,wking,wqueen,wpawn ;
	private boolean[][] go;
	private boolean wcheck,bcheck,brmove1,brmove2,wrmove1,wrmove2,np=false;
	private char p=' ',q;
	private Graphics M;
	
	public void init() {
		setLayout(null);
		q ='w';
		o = " ";
		board = new int[8][8];
		go=new boolean[8][8];
		zen = new String[8][8];
		addKeyListener(this);
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				zen[i][j]=" ";
		wcheck=bcheck=brmove1=brmove2=wrmove1=wrmove2=false;
		for(int i = 0;i<8;i++) {
			if(i%2==0) {
				c=1;
				for(int j=0;j<8;j++) {					
					c++;
					board[j][i] = c%2;
					go[i][j]=false;
				}
			}
			else {
				c=0;
				for(int j=0;j<8;j++) {					
					c++;
					board[j][i] = c%2;
					go[i][j]=false;
				}
			}
		}	
		pieces = new String[8][8];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				pieces[i][j]=" ";
		for(int i=0;i<8;i++)
			pieces[1][i]="bpawn";
		for(int i=0;i<8;i++)
			pieces[6][i]="wpawn";
		addMouseListener(this);
		M =getGraphics();
		M.setColor(Color.yellow);
		pieces[0][0]="brook";
		pieces[0][1]="bknight";
		pieces[0][2]="bbishop";
		pieces[0][3]="bqueen";
		pieces[0][4]="bking";
		pieces[0][5]="bbishop";
		pieces[0][6]="bknight";
		pieces[0][7]="brook";
		pieces[7][0]="wrook";
		pieces[7][1]="wknight";
		pieces[7][2]="wbishop";
		pieces[7][3]="wqueen";
		pieces[7][4]="wking";
		pieces[7][5]="wbishop";
		pieces[7][6]="wknight";
		pieces[7][7]="wrook";
		bking = getImage(getDocumentBase(),"bking.jpg");
		wking = getImage(getDocumentBase(),"wking.jpg");
		wpawn = getImage(getDocumentBase(),"wpawn.jpg");
		bpawn = getImage(getDocumentBase(),"t.jpg");
		wrook = getImage(getDocumentBase(),"wrook.jpg");
		brook = getImage(getDocumentBase(),"brook.jpg");
		bknight = getImage(getDocumentBase(),"bknight.jpg");
		wknight = getImage(getDocumentBase(),"wknight.jpg");
		wbishop = getImage(getDocumentBase(),"wbishop.jpg");
		bbishop = getImage(getDocumentBase(),"bbishop.JPG");
		bqueen = getImage(getDocumentBase(),"bqueen.JPG");
		wqueen = getImage(getDocumentBase(),"wqueen.JPG");
	}
	
	public void paint(Graphics g) {
		c=0;
		if(q=='w') {	
			for(int i=0;i<8;i++)
				for(int j =0;j<8;j++) {
					if(board[j][i]==0)
						g.setColor(Color.white);
					else
						g.setColor(Color.black);
					g.fillRect(j*50+20, i*50+20, 50, 50);
					if(pieces[i][j].equals("bking")) {
						g.drawImage(bking, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wking")) {
						g.drawImage(wking, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wpawn")) {
						g.drawImage(wpawn, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bpawn")) {
						g.drawImage(bpawn, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wrook")) {
						g.drawImage(wrook, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("brook")) {
						g.drawImage(brook, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bknight")) {
						g.drawImage(bknight, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wknight")) {
						g.drawImage(wknight, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wbishop")) {
						g.drawImage(wbishop, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bbishop")) {
						g.drawImage(bbishop, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bqueen")) {
						g.drawImage(bqueen, j*50+20,i*50+20,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wqueen")) {
						g.drawImage(wqueen, j*50+20,i*50+20,50,50,this);
						c++;
					}
					if(!pieces[i][j].equalsIgnoreCase(" ")) {
						if(board[j][i]==0)
							g.setColor(Color.white);
						else
							g.setColor(Color.black);
					}
					g.setColor(Color.black);
					g.drawRect(j*50+20, i*50+20, 50, 50);
				}
			g.setColor(Color.black);
			g.drawRect(20, 20, 400, 400);
		}
		else {
			for(int i=0;i<8;i++)
				for(int j =0;j<8;j++) {
					if(board[j][i]==0)
						g.setColor(Color.white);
					else
						g.setColor(Color.black);
					g.fillRect(370 - j*50, 370 -i*50, 50, 50);
					if(pieces[i][j].equals("bking")) {
						g.drawImage(bking, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wking")) {
						g.drawImage(wking, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wpawn")) {
						g.drawImage(wpawn, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bpawn")) {
						g.drawImage(bpawn, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wrook")) {
						g.drawImage(wrook, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("brook")) {
						g.drawImage(brook, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bknight")) {
						g.drawImage(bknight, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wknight")) {
						g.drawImage(wknight, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wbishop")) {
						g.drawImage(wbishop, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bbishop")) {
						g.drawImage(bbishop, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("bqueen")) {
						g.drawImage(bqueen, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					else if(pieces[i][j].equals("wqueen")) {
						g.drawImage(wqueen, 370-j*50,370-i*50,50,50,this);
						c++;
					}
					if(!pieces[i][j].equalsIgnoreCase(" ")) {
						if(board[j][i]==0)
							g.setColor(Color.white);
						else
							g.setColor(Color.black);
					}
					g.setColor(Color.black);
					g.drawRect(370-j*50, 370-i*50, 50, 50);
				}
			g.setColor(Color.black);
			g.drawRect(20, 20, 400, 400);
		}
	}
		
	public void mousePressed(MouseEvent e) {
		n = 0;
		M.setColor(Color.orange);
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				zen[i][j]=pieces[i][j];
		xpos = e.getX();
		ypos = e.getY();
		y = (xpos - 20)/50;
		x = (ypos - 20)/50;
		if(q=='b') {
			y = 7-y;
			x=7-x;
		}
		tx=x;
		ty=y;
		if(!np) {
			if(e.isMetaDown()) {
				p=' ';
				for(int i=0;i<8;i++)
					for(int j=0;j<8;j++)
						go[i][j]=false;
				repaint();
			}
			else if(inbounds(x,y)) {
				if((p=='w')||(p=='b')) {
					showStatus("");
					if(go[x][y]) {
						if(pieces[x2][y2].equals("brook")){	
							if(y2==0)
								brmove1 = true;
							else
								brmove2 = true;
						}	
						if(pieces[x2][y2].equals("wrook")) {
							if(y2==0)
								wrmove1 = true;
							else
								wrmove2=true;
						}
						if(pieces[x2][y2].equals("bking"))
							bcheck = true;
						if(pieces[x2][y2].equals("wking"))
							wcheck = true;
						if((inbounds(x,y+1))&&(pieces[x][y+1].substring(1, pieces[x][y+1].length()).equals("rook"))&&(pieces[x2][y2].substring(1, pieces[x2][y2].length()).equals("king"))) {
							piece=pieces[x][y+1];
							pieces[x][y]=pieces[x2][y2];
							pieces[x][y-1] = piece;
							pieces[x2][y2]=" ";
							pieces[x][y+1]=" ";
						}
						else if((inbounds(x,y-2))&&(pieces[x][y-2].substring(1, pieces[x][y-2].length()).equals("rook"))&&(pieces[x2][y2].substring(1, pieces[x2][y2].length()).equals("king"))) {
							piece=pieces[x][y-2];
							pieces[x][y]=pieces[x2][y2];
							pieces[x][y+1] = piece;
							pieces[x2][y2]=" ";
							pieces[x][y-2]=" ";
						}
						else {
							pieces[x][y]=pieces[x2][y2];
							pieces[x2][y2]=" ";
						}
						if(((x==7)||(x==0))&&(pieces[x][y].substring(1).equals("pawn"))) {
							np=true;
							showStatus("New Piece");
							x3=x;
							y3=y;
						}
						for(int i=0;i<8;i++)
							for(int j=0;j<8;j++)
								go[i][j]=false;
						p=' ';
						if(q=='w')
							q='b';
						else
							q='w';
						repaint();
						wc = bc = n =0;
						if(wcheck(pieces)>0) {
							wcheck = true;
							showStatus("Check");			
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++) {
									zen[i][j] = pieces[i][j];
									if(pieces[i][j].equals("wking")) {
										x=i;
										y=j;
										tx=x;
										ty=y;
									}
								}
							zen[x][y] = " ";
							x++;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else 
									wc++;
								n++;
								zen[x][y] = o;
							}
							y++;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							x--;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							x--;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							y--;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							y--;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							x++;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							x++;
							if((inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b')))) {
								o = pieces[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									wc++;
								n++;
								zen[x][y] = o;
							}
							zen[tx][ty] = "wking";
							//System.out.println(""+wc + " "+n + " " + savekingwp(zen)+ " " + savekingwb(zen) + " "+savekingwq(zen) + " " + savekingwk(zen)+ " " + savekingwr(zen));
							if((wc==n)&&(savekingwp(zen))&&(savekingwb(zen))&&(savekingwr(zen))&&(savekingwq(zen))&&(savekingwk(zen)))
								showStatus("Checkmate!");
							//showStatus(""+wc + " "+n + " " + savekingwp(zen)+ " " + savekingwb(zen) + " "+savekingwq(zen) + " " + savekingwk(zen)+ " " + savekingwr(zen));
							//System.out.println(""+ zen[tx][ty]);
						}		
						else if(bcheck(pieces)>0) {
							bcheck = true;
							showStatus("Check");
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++) {
									zen[i][j] = pieces[i][j];
									if(pieces[i][j].equals("bking")) {
										x=i;
										y=j;
										tx=i;
										ty=j;
										//showStatus("" +x + " " + y);
									}
								}	
							zen[x][y] = " ";
						//	System.out.println(""+ tx+ " " + ty);
							x++;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else 
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							y++;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							y-=2;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							x--;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							x--;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							y++;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							y++;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							//System.out.println(""+ x+ " " + y);
							x++;
							if((inbounds(x,y))&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = pieces[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									//M.setColor(Color.red);
									//M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								else
									bc++;
								n++;
								zen[x][y] = o;
							}
							zen[tx][ty] = "bking"; 
							/*for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									M.drawString(zen[i][j] , j*40 +20, i*20 +450);*/
							//System.out.println(""+ tx+ " " + ty);
							//System.out.println(""+savekingbp(zen));
							//System.out.println(""+savekingbq(zen));
							//System.out.print(""+bc + " "+n + " " + savekingbp(zen)+ " " + savekingbb(zen) + " "+savekingbq(zen) + " " + savekingbk(zen)+ " " + savekingbr(zen));
							//System.out.println("" + zen[tx][ty]);
							if((bc==n)&&(savekingbp(zen))&&(savekingbb(zen))&&(savekingbq(zen)&&(savekingbr(zen))))
								showStatus("Checkmate!");
							//showStatus(""+bc + " "+n + " " + savekingbp(zen)+ " " + savekingbb(zen) + " "+savekingbq(zen) + " " + savekingbk(zen)+ " " + savekingbr(zen));
							//System.out.println("" + zen[tx][ty] + "1");
						}		
					}
				}
				else {
					for(int i=0;i<8;i++)
						for(int j=0;j<8;j++)
							go[i][j]=false;
					if(q=='w') {
						if(pieces[x][y].equals("wking")) {
							zen[x][y]=" ";
							x++;
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {
								o = zen[x][y];
								zen[x][y] = "wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;	
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {	
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {	
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {	
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='b'))) {
								o = zen[x][y];
								zen[x][y]="wking";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50,x*50+50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;
							if((x==7)&&(y==4)&&(!wcheck)&&(pieces[x][y].equals("wking"))&&(pieces[7][0].equals("wrook"))&&(!wrmove1)&&(pieces[7][1].equals(" "))&&(pieces[7][2].equals(" ")&&(pieces[7][3].equals(" ")))) {
								zen[x][y] = " ";
								zen[7][3] = "wking";
								if(wcheck(zen)==0) {
									zen[7][3] = " ";
									zen[7][2] = "wking";
									if(wcheck(zen)==0) {
										M.fillRect(2*50+50,7*50+50,20,20);
										go[7][2] = true;
									}
								}
								zen[7][2]=" ";
								zen[7][3]= " ";
							}
							if((x==7)&&(y==4)&&(!wcheck)&&(pieces[x][y].equals("wking"))&&(pieces[7][7].equals("wrook"))&&(!wrmove2)&&(pieces[7][5].equals(" "))&&(pieces[7][6].equals(" "))) {
								zen[x][y] = " ";
								zen[7][5] = "wking";
								if(wcheck(zen)==0) {
									zen[7][5]=" ";
									zen[7][6] = "wking";
									if(wcheck(zen)==0) {
										M.fillRect(6*50+50,7*50+50,20,20);
										go[7][6] = true;
									}
									zen[7][6] = " ";
								}
								zen[7][5] =" ";
							}
							//showStatus(" "+x +" , "+y);
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else if(pieces[x][y].equals("wpawn")) {
							zen[x][y]=" ";
							x--;
							if((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								o = zen[x][y];
								zen[x][y]="wpawn";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
									zen[x][y]=o;
									if((x==5)&&(pieces[x-1][y].equals(" "))) {
										x--;
										o = zen[x][y];
										zen[x][y]="wpawn";
										if(wcheck(zen)==0) {
											M.fillRect(y*50+50, x*50+50, 20, 20);
											go[x][y]=true;
										}
										x++;
										zen[x][y]=o;
									}	
								}
							}
							x++;
							if((inbounds(x-1,y+1))&&(pieces[x-1][y+1].charAt(0)=='b')) {
								o = zen[x-1][y+1];
								zen[x-1][y+1]="wpawn";
								if(wcheck(zen)==0) {
									M.fillRect((y+1)*50+50, (x-1)*50+50, 20, 20);
									go[x-1][y+1]=true;
								}
								zen[x-1][y+1]=o;
							}
							if((inbounds(x-1,y-1))&&(pieces[x-1][y-1].charAt(0)=='b')) {
								o = zen[x-1][y-1];
								zen[x-1][y-1]="wpawn";
								if(wcheck(zen)==0) {
									M.fillRect((y-1)*50+50, (x-1)*50+50, 20, 20);
									go[x-1][y-1]=true;
								}
								zen[x-1][y-1] = o;
							}
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else if(pieces[x][y].equals("wqueen")) {
							zen[x][y] = " ";
							while((inbounds(x+1,y))&&(pieces[x+1][y].equals(" "))) {
								x++;
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]= o;
							}
							x++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							x= tx;
							while((inbounds(x-1,y))&&(pieces[x-1][y].equals(" "))) {
								x--;
								o = zen[x][y];
								zen[x][y]= "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]= o;
							}
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]= "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							x= tx;
							while((inbounds(x,y+1))&&(pieces[x][y+1].equals(" "))) {
								y++;
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]= o;
							}
							y= ty;
							while((inbounds(x,y-1))&&(pieces[x][y-1].equals(" "))) {
								y--;
								o = zen[x][y];
								zen[x][y]= "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]= o;
							}
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y= ty;
							while((inbounds(x+1,y-1))&&(pieces[x+1][y-1].equals(" "))) {
								y--;
								x++;
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x++;
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							y = ty;
							x = tx;
							while((inbounds(x-1,y-1))&&(pieces[x-1][y-1].equals(" "))) {
								y--;
								x--;
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							x--;
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							while((inbounds(x+1,y+1))&&(pieces[x+1][y+1].equals(" "))) {
								y++;
								x++;
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							x++;
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							while((inbounds(x-1,y+1))&&(pieces[x-1][y+1].equals(" "))) {
								y++;
								x--;
								o = zen[x][y];
								zen[x][y]="wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y++;
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]= "wqueen";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else if(pieces[x][y].equals("wrook"))  {
							zen[x][y] = " ";
							while((inbounds(x+1,y))&&(pieces[x+1][y].equals(" "))) {
								x++;
								zen[x][y]="wrook";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							x++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]="wrook";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = o;
							}
							x=tx;
							while((inbounds(x-1,y))&&(pieces[x-1][y].equals(" "))) {
								x--;
								zen[x][y]= "wrook";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y]= " ";
							}
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y]= "wrook";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							while((inbounds(x,y+1))&&(pieces[x][y+1].equals(" "))) {
								y++;
								zen[x][y] = "wrook";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wrook";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							y=ty;
							while((inbounds(x,y-1))&&(pieces[x][y-1].equals(" "))) {
								y--;
								zen[x][y]= "wrook";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wrook";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else if(pieces[x][y].equals("wknight")) {
							zen[x][y]=" ";
							if((inbounds(x+2,y+1))&&(pieces[x+2][y+1].equals(" "))) {
								x+=2;
								y++;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] =" ";
							}
							else if((inbounds(x+2,y+1))&&(pieces[x+2][y+1].charAt(0)=='b')) {
								x+=2;
								y++;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]= o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+2,y-1))&&(pieces[x+2][y-1].equals(" "))) {
								x+=2;
								y--;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							else if((inbounds(x+2,y-1))&&(pieces[x+2][y-1].charAt(0)=='b')) {
								x+=2;
								y--;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-2,y+1))&&(pieces[x-2][y+1].equals(" "))) {
								x-=2;
								y++;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-2,y+1))&&(pieces[x-2][y+1].charAt(0)=='b')) {
								x-=2;
								y++;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y]=o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-2,y-1))&&(pieces[x-2][y-1].equals(" "))) {
								x-=2;
								y--;
								zen[x][y]= "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-2,y-1))&&(pieces[x-2][y-1].charAt(0)=='b')) {
								x-=2;
								y--;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+1,y+2))&&(pieces[x+1][y+2].equals(" "))) {
								x++;
								y+=2;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x+1,y+2))&&(pieces[x+1][y+2].charAt(0)=='b')) {
								x++;
								y+=2;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-1,y+2))&&(pieces[x-1][y+2].equals(" "))) {
								x--;
								y+=2;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-1,y+2))&&(pieces[x-1][y+2].charAt(0)=='b')) {
								x--;
								y+=2;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+1,y-2))&&(pieces[x+1][y-2].equals(" "))) {
								x++;
								y-=2;
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							else if((inbounds(x+1,y-2))&&(pieces[x+1][y-2].charAt(0)=='b')) {
								x++;
								y-=2;
								o = zen[x][y];
								zen[x][y]="wnight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-1,y-2))&&(pieces[x-1][y-2].equals(" "))) {
								x--;
								y-=2;
								zen[x][y] = "wnight";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-1,y-2))&&(pieces[x-1][y-2].charAt(0)=='b')) {
								x--;
								y-=2;
								o = zen[x][y];
								zen[x][y] = "wknight";
								if(wcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(y*50+50, x*50+50, 20, 20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else if(pieces[x][y].equals("wbishop")) {
							zen[x][y] =" ";
							x--;
							y--;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x--;
								y--;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o= zen[x][y];
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							x++;
							y--;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x++;
								y--;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							x++;
							y++;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x++;
								y++;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							x--;
							y++;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x--;
								y++;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='b')) {
								o = zen[x][y];
								zen[x][y] = "wbishop";
								if(wcheck(zen)==0) {
									M.fillRect(y*50+50, x*50+50, 20, 20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='b';
						}
						else
							p=' ';
						if(p=='b') {
							x2=x;
							y2=y;
						}
					}
					else {
						if(pieces[x][y].equals("bking")) {
							zen[x][y]=" ";
							x++;
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = zen[x][y];
								zen[x][y] = "bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;	
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {	
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x--;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {	
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {	
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							x++;
							if(inbounds(x,y)&&((pieces[x][y].equals(" "))||(pieces[x][y].charAt(0)=='w'))) {
								o = zen[x][y];
								zen[x][y]="bking";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y] = true;
								}
								zen[x][y]=o;
							}
							y--;
							if((x==0)&&(y==4)&&(!bcheck)&&(pieces[x][y].equals("bking"))&&(pieces[0][0].equals("brook"))&&(!brmove1)&&(pieces[0][1].equals(" "))&&(pieces[0][2].equals(" ")&&(pieces[0][3].equals(" ")))) {
								zen[x][y] = " ";
								zen[0][3] = "bking";
								if(bcheck(zen)==0) {
									zen[0][3] = " ";
									zen[0][2] = "bking";
									if(bcheck(zen)==0) {
										M.fillRect(150,50,20,20);
										go[0][2] = true;
									}
								}
								zen[0][2]=" ";
								zen[0][3]= " ";
							}
							if((x==0)&&(y==4)&&(!bcheck)&&(pieces[x][y].equals("bking"))&&(pieces[0][7].equals("brook"))&&(!brmove2)&&(pieces[0][5].equals(" "))&&(pieces[0][6].equals(" "))) {
								zen[x][y] = " ";
								zen[0][5] = "bking";
								if(bcheck(zen)==0) {
									zen[0][5]=" ";
									zen[0][6] = "bking";
									if(bcheck(zen)==0) {
										M.fillRect(350,50,20,20);
										go[0][6] = true;
									}
									zen[0][6] = " ";
								}
								zen[0][5] =" ";
							}
							//showStatus(" "+x +" , "+y);
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else if(pieces[x][y].equals("bpawn")) {
							zen[x][y]=" ";
							x++;
							if((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								o = zen[x][y];
								zen[x][y]="bpawn";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
									zen[x][y]=o;
									if((x==2)&&(pieces[x+1][y].equals(" "))) {
										x++;
										o = zen[x][y];
										zen[x][y]="bpawn";
										if(bcheck(zen)==0) {
											M.fillRect(400-y*50,400-x*50,20,20);
											go[x][y]=true;
										}
										x--;
										zen[x][y]=o;
									}	
								}
							}
							x--;
							if((inbounds(x+1,y+1))&&(pieces[x+1][y+1].charAt(0)=='w')) {
								o = zen[x+1][y+1];
								zen[x+1][y+1]="bpawn";
								if(bcheck(zen)==0) {
									M.fillRect(400-(y+1)*50, 400-(x+1)*50, 20, 20);
									go[x+1][y+1]=true;
								}
								zen[x+1][y+1]=o;
							}
							if((inbounds(x+1,y-1))&&(pieces[x+1][y-1].charAt(0)=='w')) {
								o = zen[x+1][y-1];
								zen[x+1][y-1]="bpawn";
								if(bcheck(zen)==0) {
									M.fillRect(400-(y-1)*50,400- (x+1)*50, 20, 20);
									go[x+1][y-1]=true;
								}
								zen[x+1][y-1] = o;
							}
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else if(pieces[x][y].equals("bqueen")) {
							zen[x][y] = " ";
							while((inbounds(x+1,y))&&(pieces[x+1][y].equals(" "))) {
								x++;
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]= o;
							}
							x++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							x= tx;
							while((inbounds(x-1,y))&&(pieces[x-1][y].equals(" "))) {
								x--;
								o = zen[x][y];
								zen[x][y]= "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]= o;
							}
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]= "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							x= tx;
							while((inbounds(x,y+1))&&(pieces[x][y+1].equals(" "))) {
								y++;
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]= o;
							}
							y= ty;
							while((inbounds(x,y-1))&&(pieces[x][y-1].equals(" "))) {
								y--;
								o = zen[x][y];
								zen[x][y]= "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]= o;
							}
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y= ty;
							while((inbounds(x+1,y-1))&&(pieces[x+1][y-1].equals(" "))) {
								y--;
								x++;
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x++;
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							y = ty;
							x = tx;
							while((inbounds(x-1,y-1))&&(pieces[x-1][y-1].equals(" "))) {
								y--;
								x--;
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							x--;
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							while((inbounds(x+1,y+1))&&(pieces[x+1][y+1].equals(" "))) {
								y++;
								x++;
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							x++;
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							while((inbounds(x-1,y+1))&&(pieces[x-1][y+1].equals(" "))) {
								y++;
								x--;
								o = zen[x][y];
								zen[x][y]="bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y++;
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]= "bqueen";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							y = ty;
							x = tx;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else if(pieces[x][y].equals("brook"))  {
							zen[x][y] = " ";
							while((inbounds(x+1,y))&&(pieces[x+1][y].equals(" "))) {
								x++;
								zen[x][y]="brook";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							x++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]="brook";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = o;
							}
							x=tx;
							while((inbounds(x-1,y))&&(pieces[x-1][y].equals(" "))) {
								x--;
								zen[x][y]= "brook";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y]= " ";
							}
							x--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y]= "brook";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							while((inbounds(x,y+1))&&(pieces[x][y+1].equals(" "))) {
								y++;
								zen[x][y] = "brook";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							y++;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "brook";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							y=ty;
							while((inbounds(x,y-1))&&(pieces[x][y-1].equals(" "))) {
								y--;
								zen[x][y]= "brook";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							y--;
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "brook";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else if(pieces[x][y].equals("bknight")) {
							zen[x][y]=" ";
							if((inbounds(x+2,y+1))&&(pieces[x+2][y+1].equals(" "))) {
								x+=2;
								y++;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] =" ";
							}
							else if((inbounds(x+2,y+1))&&(pieces[x+2][y+1].charAt(0)=='w')) {
								x+=2;
								y++;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]= o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+2,y-1))&&(pieces[x+2][y-1].equals(" "))) {
								x+=2;
								y--;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							else if((inbounds(x+2,y-1))&&(pieces[x+2][y-1].charAt(0)=='w')) {
								x+=2;
								y--;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-2,y+1))&&(pieces[x-2][y+1].equals(" "))) {
								x-=2;
								y++;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-2,y+1))&&(pieces[x-2][y+1].charAt(0)=='w')) {
								x-=2;
								y++;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y]=o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-2,y-1))&&(pieces[x-2][y-1].equals(" "))) {
								x-=2;
								y--;
								zen[x][y]= "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-2,y-1))&&(pieces[x-2][y-1].charAt(0)=='w')) {
								x-=2;
								y--;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+1,y+2))&&(pieces[x+1][y+2].equals(" "))) {
								x++;
								y+=2;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x+1,y+2))&&(pieces[x+1][y+2].charAt(0)=='w')) {
								x++;
								y+=2;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-1,y+2))&&(pieces[x-1][y+2].equals(" "))) {
								x--;
								y+=2;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-1,y+2))&&(pieces[x-1][y+2].charAt(0)=='w')) {
								x--;
								y+=2;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							if((inbounds(x+1,y-2))&&(pieces[x+1][y-2].equals(" "))) {
								x++;
								y-=2;
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y]=" ";
							}
							else if((inbounds(x+1,y-2))&&(pieces[x+1][y-2].charAt(0)=='w')) {
								x++;
								y-=2;
								o = zen[x][y];
								zen[x][y]="bnight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							if((inbounds(x-1,y-2))&&(pieces[x-1][y-2].equals(" "))) {
								x--;
								y-=2;
								zen[x][y] = "bnight";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
							}
							else if((inbounds(x-1,y-2))&&(pieces[x-1][y-2].charAt(0)=='w')) {
								x--;
								y-=2;
								o = zen[x][y];
								zen[x][y] = "bknight";
								if(bcheck(zen)==0) {
									go[x][y]=true;
									M.fillRect(400-y*50,400-x*50,20,20);
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else if(pieces[x][y].equals("bbishop")) {
							zen[x][y] =" ";
							x--;
							y--;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x--;
								y--;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o= zen[x][y];
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							x++;
							y--;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x++;
								y--;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = o;
							}
							x=tx;
							y=ty;
							x++;
							y++;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x++;
								y++;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							x--;
							y++;
							while((inbounds(x,y))&&(pieces[x][y].equals(" "))) {
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] = " ";
								x--;
								y++;
							}
							if((inbounds(x,y))&&(pieces[x][y].charAt(0)=='w')) {
								o = zen[x][y];
								zen[x][y] = "bbishop";
								if(bcheck(zen)==0) {
									M.fillRect(400-y*50,400-x*50,20,20);
									go[x][y]=true;
								}
								zen[x][y] =o;
							}
							x=tx;
							y=ty;
							for(int i=0;i<8;i++)
								for(int j=0;j<8;j++)
									if(go[i][j])
										p='w';
						}
						else
							p=' ';
						if(p=='w') {
							x2 = x;
							y2 = y;
						}
					}
				}
			}
		}
		//showStatus(""+p);
		//showStatus(""+wc + " " + bc + " " + n);
		//showStatus("" + bcheck(pieces) + " " + wcheck(pieces));
	}
	
	public void keyReleased(KeyEvent evt) {
		
	}
	
	public void keyPressed(KeyEvent evt) {
		int key = evt.getKeyCode();
		switch(key) {
			case KeyEvent.VK_ESCAPE :	p=' ';
										for(int i=0;i<8;i++)
											for(int j=0;j<8;j++)
												go[i][j]=false;
										repaint();
										break;
			
			case KeyEvent.VK_1 :		repaint();
										break;
			
			case KeyEvent.VK_Q :		np = false;
										pieces[x3][y3] = pieces[x3][y3].charAt(0) + "queen";
										repaint();
										break;
			
			case KeyEvent.VK_B :		np = false;
										pieces[x3][y3] = pieces[x3][y3].charAt(0) + "bishop";
										repaint();
										break;
			
			case KeyEvent.VK_R :		np = false;
										pieces[x3][y3] = pieces[x3][y3].charAt(0) + "rook";
										repaint();
										break;
										
			case KeyEvent.VK_K :		np = false;
										pieces[x3][y3] = pieces[x3][y3].charAt(0) + "knight";
										repaint();
										break;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
	
	}

	public void mouseEntered(MouseEvent e) {	
	
	}
	
	public boolean inbounds(int X, int Y) {
		return ((X>=0)&&(X<=7)&&(Y>=0)&&(Y<=7));
	}
	
	public void keyTyped(KeyEvent evt) {
	
	}
	
	public int bcheck(String[][] w) {
		int ti,tj,temp=0;
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(w[i][j].equals("bking")) {
					ti=i;
					tj=j;
					if((inbounds(i-1,j-2))&&(w[i-1][j-2].equals("wknight")))
						temp++;
					if((inbounds(i+1,j-2))&&(w[i+1][j-2].equals("wknight")))
						temp++;
					if((inbounds(i-1,j+2))&&(w[i-1][j+2].equals("wknight")))
						temp++;
					if((inbounds(i+1,j+2))&&(w[i+1][j+2].equals("wknight")))
						temp++;
					if((inbounds(i-2,j-1))&&(w[i-2][j-1].equals("wknight")))
						temp++;
					if((inbounds(i+2,j-1))&&(w[i+2][j-1].equals("wknight")))
						temp++;
					if((inbounds(i-2,j+1))&&(w[i-2][j+1].equals("wknight")))
						temp++;
					if((inbounds(i+2,j+1))&&(w[i+2][j+1].equals("wknight")))
						temp++;
					i++;
					while((inbounds(i,j))&&((w[i][j].equals(" ")))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook")))
							temp++;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook"))))
						temp++;
					i=ti;
					i--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook")))
							temp++;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook"))))
						temp++;
					i=ti;
					j++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook")))
							temp++;
						j++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook"))))
						temp++;
					j=tj;
					j--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook")))
							temp++;
						j--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wrook"))))
						temp++;
					j=tj;
					if((inbounds(i+1,j+1))&&(w[i+1][j+1].equals("wpawn")))
						temp++;
					if((inbounds(i+1,j-1))&&(w[i+1][j-1].equals("wpawn")))
						temp++;
					j++;
					i++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop")))
							temp++;
						j++;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop"))))
						temp++;
					j=tj;
					i=ti;
					j++;
					i--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop")))
							temp++;
						j++;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop"))))
						temp++;
					j=tj;
					i=ti;
					i--;
					j--;
					while((inbounds(i,j))&&((w[i][j].equals(" ")))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop")))
							temp++;
						j--;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop"))))
						temp++;
					j=tj;
					i=ti;
					j--;
					i++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop")))
							temp++;
						j--;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("wqueen"))||(w[i][j].equals("wbishop"))))
						temp++;
					j=tj;
					i=ti;
				}
		return temp;
	}
	
	public int wcheck(String[][] w) {
		int ti,tj,temp=0;
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(w[i][j].equals("wking")) {
					ti=i;
					tj=j;
					if((inbounds(i-1,j-2))&&(w[i-1][j-2].equals("bknight")))
						temp++;
					if((inbounds(i+1,j-2))&&(w[i+1][j-2].equals("bknight")))
						temp++;
					if((inbounds(i-1,j+2))&&(w[i-1][j+2].equals("bknight")))
						temp++;
					if((inbounds(i+1,j+2))&&(w[i+1][j+2].equals("bknight")))
						temp++;
					if((inbounds(i-2,j-1))&&(w[i-2][j-1].equals("bknight")))
						temp++;
					if((inbounds(i+2,j-1))&&(w[i+2][j-1].equals("bknight")))
						temp++;
					if((inbounds(i-2,j+1))&&(w[i-2][j+1].equals("bknight")))
						temp++;
					if((inbounds(i+2,j+1))&&(w[i+2][j+1].equals("bknight")))
						temp++;
					i++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("brook")))
							temp++;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("brook"))))
						temp++;
					i=ti;
					i--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("brook")))
							temp++;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("brook"))))
						temp++;
					i=ti;
					j++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("brook")))
							temp++;
						j++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("brook"))))
						temp++;
					j=tj;
					j--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("brook")))
							temp++;
						j--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("brook"))))
						temp++;
					j=tj;
					if((inbounds(i-1,j+1))&&(w[i-1][j+1].equals("bpawn")))
						temp++;
					if((inbounds(i-1,j-1))&&(w[i-1][j-1].equals("bpawn")))
						temp++;
					j++;
					i++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop")))
							temp++;
						j++;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop"))))
						temp++;
					j=tj;
					i=ti;
					j++;
					i--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop")))
							temp++;
						j++;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop"))))
						temp++;
					j=tj;
					i=ti;
					i--;
					j--;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop")))
							temp++;
						j--;
						i--;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop"))))
						temp++;
					j=tj;
					i=ti;
					j--;
					i++;
					while((inbounds(i,j))&&(w[i][j].equals(" "))) {
						if((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop")))
							temp++;
						j--;
						i++;
					}
					if((inbounds(i,j))&&((w[i][j].equals("bqueen"))||(w[i][j].equals("bbishop"))))
						temp++;
					j=tj;
					i=ti;
				}
		return temp;
	}
	
	public boolean savekingwp(String[][] hope) {
		for(int i =0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("wpawn")) {
					hope[i][j] = " ";
					l = i;
					m = j;	
					l--;
					if((inbounds(l,m))&&(hope[l][m].equals(" "))) {
						hope[l][m] = "wpawn";
						if(wcheck(hope)==0)
							return false;				
						hope[l][m] = " ";
						l--;
						if((inbounds(l,m))&&(hope[l][m].equals(" "))&&(l==4)) {	
							hope[l][m] = "wpawn";
							if(wcheck(hope)==0)
								return false;
							hope[l][m] = " ";
						}
					}
					l++;
					m++;
					if(inbounds(l,m)) {	
						o = hope[l][m];
						if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b'))
							hope[l][m] = "wpawn";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					m-=2;
					if(inbounds(l,m)) {
						o = hope[l][m];
						if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b'))
							hope[l][m] = "wpawn";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;			
					hope[l][m] = "wpawn";
				}
		return true;
	}
	
	public boolean savekingwb(String[][] hope) {
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("wbishop")) {
					l=i;
					m=j;
					hope[l][m] = " ";
					l++;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" "))) {
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b')) {
						o = hope[l][m];
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l--;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" "))) {
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b')) {
						o = hope[l][m];
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l--;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" "))) {
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b')) {
						o = hope[l][m];
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l++;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" "))) {
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='b')) {
						o = hope[l][m];
						hope[l][m] = "wbishop";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					hope[l][m] = "wbishop";
				}
			return true;
		}

	public boolean savekingwk(String[][] hope) {
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("wknight")) {
					l = i;
					m = j;
					hope[l][m] = " ";
					l++;
					m+=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w')) {
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l+=2;
					m++;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w')) {
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l+=2;
					m--;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w')) {
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l--;
					m+=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w')) {
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l-=2;
					m--;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w')) {
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l--;
					m-=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l-=2;
					m++;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l++;
					m-=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] =  "wknight";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					hope[l][m]= "wknight";
				}
		return true;
}

	public boolean savekingwq(String[][] hope)
	{
		for(int i =0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("wqueen"))
				{
					l = i;
					m = j;
					hope[l][m] = " ";
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					l = i;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					l = i;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					m++;
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m++;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m--;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m--;
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='w'))
					{
						o = hope[l][m];
						hope[l][m] = "wqueen";
						if(wcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					hope[l][m] = "wqueen";
				}
		return true;
	}

	public boolean savekingwr(String[][] hope)
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("wrook"))
				{
					x=i;
					y=j;
					hope[i][j]=" ";
					x++;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						x++;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='b'))
					{
						o = hope[x][y];
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					x=i;
					x--;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						x--;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='b'))
					{
						o = hope[x][y];
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					y=j;
					y++;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						y++;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='b'))
					{
						o = hope[x][y];
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					y=j;
					y--;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						y--;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='b'))
					{
						o = hope[x][y];
						hope[x][y] = "wrook";
						if(wcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}				
					x=i;
					y=j;
					hope[x][y]= "wrook";
				}
		return true;
	}
	
	public boolean savekingbp(String[][] hope)
	{
		for(int i =0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("bpawn"))
				{
					hope[i][j] = " ";
					l = i;
					m = j;	
					l++;
					if((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m] = "bpawn";
						if(bcheck(hope)==0)
							return false;				
						hope[l][m] = " ";
						l++;
					if((inbounds(l,m))&&(hope[l][m].equals(" "))&&(l==3))
						{	
							hope[l][m] = "bpawn";
							if(bcheck(hope)==0)
								return false;
							hope[l][m] = " ";
						}
					}
					l--;
					m++;
					if(inbounds(l,m))
					{	
						o = hope[l][m];
						if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
							hope[l][m] = "bpawn";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					m-=2;
					if(inbounds(l,m))
					{
						o = hope[l][m];
						if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
							hope[l][m] = "bpawn";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;			
					hope[l][m] = "bpawn";
				}
		return true;
	}
	
	public boolean savekingbb(String[][] hope)
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("bbishop"))
				{
					l=i;
					m=j;
					hope[l][m] = " ";
					l++;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
					{
						o = hope[l][m];
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l--;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
					{
						o = hope[l][m];
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l--;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
					{
						o = hope[l][m];
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					l++;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)=='w'))
					{
						o = hope[l][m];
						hope[l][m] = "bbishop";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					hope[l][m] = "bbishop";
				}
			return true;
		}

	public boolean savekingbk(String[][] hope)
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("bknight"))
				{
					l = i;
					m = j;
					hope[l][m] = " ";
					l++;
					m+=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l+=2;
					m++;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l+=2;
					m--;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l--;
					m+=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l-=2;
					m--;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l--;
					m-=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l-=2;
					m++;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m = j;
					l++;
					m-=2;
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] =  "bknight";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = o;
					}
					l=i;
					m=j;
					hope[l][m]= "bknight";
				}
		return true;
}

	public boolean savekingbq(String[][] hope)
	{
		for(int i =0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("bqueen"))
				{
					l = i;
					m = j;
					hope[l][m] = " ";
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					l = i;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					l = i;
					m++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					m--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					m++;
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m++;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m++;
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m--;
					l--;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
						l--;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					m--;
					l++;
					while((inbounds(l,m))&&(hope[l][m].equals(" ")))
					{
						hope[l][m]="bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] = " ";
						m--;
						l++;
					}
					if((inbounds(l,m))&&(hope[l][m].charAt(0)!='b'))
					{
						o = hope[l][m];
						hope[l][m] = "bqueen";
						if(bcheck(hope)==0)
							return false;
						hope[l][m] =o;
					}
					m = j;
					l=i;
					hope[l][m] = "bqueen";
				}
		return true;
	}

	public boolean savekingbr(String[][] hope)
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				if(hope[i][j].equals("brook"))
				{
					x=i;
					y=j;
					hope[i][j]=" ";
					x++;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						x++;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='w'))
					{
						o = hope[x][y];
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					x=i;
					x--;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						x--;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='w'))
					{
						o = hope[x][y];
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					y=j;
					y++;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						y++;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='w'))
					{
						o = hope[x][y];
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}
					y=j;
					y--;
					while((inbounds(x,y))&&(hope[x][y].equals(" ")))
					{
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = " ";
						y--;
					}
					if((inbounds(x,y))&&(hope[x][y].charAt(0)=='w'))
					{
						o = hope[x][y];
						hope[x][y] = "brook";
						if(bcheck(hope)==0)
							return false;
						hope[x][y] = o;
					}				
					x=i;
					y=j;
					hope[x][y]= "brook";
				}
		return true;
	}	
}