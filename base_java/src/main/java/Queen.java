/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * ������Ϊ���ڿ����տ������ơ�δ������˾��ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á�
 * ���ơ��޸Ļ򷢲�������.
 ******************************************************************************/

/**
 * FIXME ��ע����Ϣ
 * 
 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-03-31
 */
public class Queen {
	// ͬ���Ƿ��лʺ�1��ʾ��
	private int[] column;

	// �����������Ƿ��лʺ�
	private int[] rup;

	// �����������Ƿ��лʺ�
	private int[] lup;

	// ���
	private int[] queen;

	// �����
	private int num;

	public Queen() {
		column = new int[8 + 1];
		rup = new int[(2 * 8) + 1];
		lup = new int[(2 * 8) + 1];

		for (int i = 1; i <= 8; i++)
			column[i] = 1;

		for (int i = 1; i <= (2 * 8); i++)
			rup[i] = lup[i] = 1;

		queen = new int[8 + 1];
	}

	public void backtrack(int i) {
		if (i > 8) {
			showAnswer();
		} else {
			for (int j = 1; j <= 8; j++) {
				if ((column[j] == 1) && (rup[i + j] == 1)
						&& (lup[i - j + 8] == 1)) {
					queen[i] = j;
					// �趨Ϊռ��
					column[j] = rup[i + j] = lup[i - j + 8] = 0;
					backtrack(i + 1);
					column[j] = rup[i + j] = lup[i - j + 8] = 1;
				}
			}
		}
	}

	protected void showAnswer() {
		num++;
		System.out.println("\n���" + num);

		for (int y = 1; y <= 8; y++) {
			for (int x = 1; x <= 8; x++) {
				if (queen[y] == x) {
					System.out.print("Q");
				} else {
					System.out.print(".");
				}
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		Queen queen = new Queen();
		queen.backtrack(1);
	}
}