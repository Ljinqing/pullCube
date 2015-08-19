package ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.App;

public class MainFrame extends JFrame implements KeyListener{
	JLabel lab_wolf;
	int[][] datas ;
	public void MainFrame1(int[][] mdat){//����һ��data�����������ϰ�
		//�������ͼƬ���ʱ�����˳��
		//���ͼƬ�����˳��
		//���ӳ�ʼ��
/*		targetInit();
		//�����ʼ��
		wolfInit();
		//���ӳ�ʼ��
		//sheepInit();
		//��ľ��ʼ��
		treeInit();
		//������ʼ��
	//	backgroundInit();
		setMainFrameUI();
		//����һ��������
*/		datas = mdat;
		this.addKeyListener(this);
	}
	//����һ��������ģ����ȫ��ͬ��JLabel����
	JLabel sheeps[][] = new JLabel[12][16];
	//��������ģ�⣬ʹ�ö�ά����ģ��
	//0����յأ�1�����ϰ���4�������ӡ�
/*	int[][] datas = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,1,1,0,0,0,0,1,1,1,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,1,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,1,1,1,1,1,1,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};*/
	//�������λ��
	int wx;
	//��������λ��
	int wy;
	//�������ϰ���ĳ�ʼ��
	public void treeInit(){
		Icon ic = new ImageIcon(MainFrame.class.getResource("tree.png"));
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				JLabel lab_tree = new JLabel(ic);
				//���ô�Сλ��
				if(datas[i][j]==1){
				lab_tree.setBounds(12+50*j, 36+50*i, 50, 50);
				}

				//��ӵ�������
				this.add(lab_tree);
			}
		}
	}
	//���ӳ�ʼ��
	public void targetInit(){
		Icon i  = new ImageIcon(MainFrame.class.getResource("target.png"));
		JLabel lab_target1 = new JLabel(i);
		lab_target1.setBounds(712, 236, 50, 50);
		this.add(lab_target1);
		JLabel lab_target2 = new JLabel(i);
		lab_target2.setBounds(712, 286, 50, 50);
		this.add(lab_target2);
		JLabel lab_target3 = new JLabel(i);
		lab_target3.setBounds(712, 336, 50, 50);
		this.add(lab_target3);
	}
	//���������ӵĳ�ʼ��
	public void sheepInit(int x1,int y1,int x2,int y2,int x3,int y3){
		//�������ӵ�ģ��
		Icon i = new ImageIcon(MainFrame.class.getResource("cube.png"));
		JLabel  lab_sheep1 = new JLabel(i);
		lab_sheep1.setBounds(x1,y1,50,50);
		//��������ӵ�������
		this.add(lab_sheep1);
		datas[(y1-36)/50][(x1-12)/50] = 4;
		sheeps[(y1-36)/50][(x1-12)/50]=lab_sheep1;
		//�����ڶ������ӣ���ͼƬ����Ҫ����
		JLabel lab_sheep2 = new JLabel(i);
		lab_sheep2.setBounds(x2, y2, 50, 50);
		this.add(lab_sheep2);
		datas[(y2-36)/50][(x2-12)/50] =4;
		sheeps[(y2-36)/50][(x2-12)/50] =lab_sheep2;
		JLabel lab_sheep3 = new JLabel(i);
		lab_sheep3.setBounds(x3,y3, 50, 50);
		this.add(lab_sheep3);
		//�޸����Ӷ�Ӧλ���ϵ�����
		datas[(y3-36)/50][(x3-12)/50]  = 4;
		sheeps[(y3-36)/50][(x3-12)/50] =lab_sheep3;
		
	}
	//����������ĳ�ʼ��
	public void wolfInit(int wx,int wy){
		this.wx=wx;
		this.wy=wy;
		Icon i = new ImageIcon(MainFrame.class.getResource("down.png"));
		//ʹ��JLabel���ģ������
		lab_wolf = new JLabel(i);
		//��������λ��
		lab_wolf.setBounds(12+wy*50,36+wx*50,50,50);
		//��������봰����
		this.add(lab_wolf);
		
	}
		//������ʼ��
	public void backgroundInit() {
		Icon i = new ImageIcon(MainFrame.class.getResource("bg.png"));
		JLabel lab_bg = new JLabel(i);
		//����Ҫ��������λ�����С
		lab_bg.setBounds(12,36,800,600);
		this.add(lab_bg);
	}

	public void setMainFrameUI(){
		//���ô������ɲ���
		this.setLayout(null);
		this.setTitle("������");
		this.setLocation(150, 50);
		this.setSize(826,650);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int x =(int)lab_wolf.getLocation().getX();
		int y = (int)lab_wolf.getLocation().getY();
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key){
		case 37:
			if(datas[wx][wy-1]==1){//�����ϰ�
				return;
			}	
			if(datas[wx][wy-1]==4){//��������
				if(datas[wx][wy-2]!=4&&datas[wx][wy-2]!=1){
				//�������ƶ�һ���ƶ�֮��ǰλ�ñ�Ϊ0
				datas[wx][wy-1]=0;
				//��һλ�ñ�Ϊ4
				datas[wx][wy-2]=4;
				//������ʾλ�ñ仯
				sheeps[wx][wy-1].setLocation(12+wy*50-100,36+wx*50);
				sheeps[wx][wy-2]= sheeps[wx][wy-1];
				sheeps[wx][wy-1]=null;
					//------�����ƶ���ʼ-----
				lab_wolf.setLocation(x-50,y);
					//�����ƶ������ͼƬ����
				Icon i = new ImageIcon(MainFrame.class.getResource("left.png"));
				lab_wolf.setIcon(i);
				wy=wy-1;
				return;
				//------�����ƶ�����-----
				}
				}
			if(datas[wx][wy-1]==0){
				lab_wolf.setLocation(x-50,y);
					//�����ƶ������ͼƬ����
				Icon i = new ImageIcon(MainFrame.class.getResource("left.png"));
				lab_wolf.setIcon(i);
				wy=wy-1;
			}
				break;
		case 38:
			if(datas[wx-1][wy]==1){
				return;
			}	
			if(datas[wx-1][wy]==4){
				if(datas[wx-2][wy]!=4&&datas[wx-2][wy]!=1){
				datas[wx-2][wy]=4;
				datas[wx-1][wy]=0;
				sheeps[wx-1][wy].setLocation(12+wy*50,36+wx*50-100);
				sheeps[wx-2][wy]=sheeps[wx-1][wy];
				sheeps[wx-1][wy]=null;
				//�����ƶ�
				lab_wolf.setLocation(x,y-50);
				Icon j = new ImageIcon(MainFrame.class.getResource("up.png"));
				lab_wolf.setIcon(j);
				wx=wx-1;
				return;
				}
			}
			if(datas[wx-1][wy]==0){
			lab_wolf.setLocation(x,y-50);
			Icon j = new ImageIcon(MainFrame.class.getResource("up.png"));
			lab_wolf.setIcon(j);
			wx=wx-1;
			}
			break;
		case 39:
			if(datas[wx][wy+1]==1){
				return;
			}	
			if(datas[wx][wy+1]==4){
				if(datas[wx][wy+2]!=4&&datas[wx][wy+2]!=1){
				datas[wx][wy+2]=4;
				datas[wx][wy+1]=0;
				sheeps[wx][wy+1].setLocation(12+wy*50+100,36+wx*50);
				sheeps[wx][wy+2]=sheeps[wx][wy+1];
				sheeps[wx][wy+1]=null;
				//�����ƶ�
				lab_wolf.setLocation(x+50,y);
				Icon k = new ImageIcon(MainFrame.class.getResource("right.png"));
				lab_wolf.setIcon(k);
				wy=wy+1;
				return;
				}
			}
			if(datas[wx][wy+1]==0){
			lab_wolf.setLocation(x+50,y);
			Icon k = new ImageIcon(MainFrame.class.getResource("right.png"));
			lab_wolf.setIcon(k);
			wy=wy+1;
			}
			break;
		case 40:
			if(datas[wx+1][wy]==1){
				return;
			}	
			if(datas[wx+1][wy]==4){
				if(datas[wx+2][wy]!=4&&datas[wx+2][wy]!=1){
				datas[wx+2][wy]=4;
				datas[wx+1][wy]=0;
				sheeps[wx+1][wy].setLocation(12+wy*50,36+wx*50+100);
				sheeps[wx+2][wy]=sheeps[wx+1][wy];
				sheeps[wx+1][wy]=null;
				//�����ƶ�
				lab_wolf.setLocation(x,y+50);
				Icon l = new ImageIcon(MainFrame.class.getResource("down.png"));
				lab_wolf.setIcon(l);
				wx=wx+1;
				return;
			}
			}
			if(datas[wx+1][wy]==0){
			lab_wolf.setLocation(x,y+50);
			Icon l = new ImageIcon(MainFrame.class.getResource("down.png"));
			lab_wolf.setIcon(l);
			wx=wx+1;
			}
			break;
			default:
				break;
		}
		//Success.cheng(datas);
		if(datas[4][14]==4&&datas[5][14]==4&&datas[6][14]==4){
			Count.count++;
			new App().re(Count.count,this);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
