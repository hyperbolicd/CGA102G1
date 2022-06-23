package com.merchandise_inf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class teeet {
	public static void main(String[] args) throws SQLException, IOException {
//		File fi = new File("C:\\CGA102_WebApp\\eclipse_WTP_workspace1\\CGA102_Group1\\src\\main\\java\\com\\merchandise_inf\\model\\image1.jpg");
		File fi = new File("image1.jpg");
		FileInputStream fis = new FileInputStream(fi);
		byte[] byteArray = new byte[fis.available()];
		fis.read(byteArray);
		Blob blob = new SerialBlob(byteArray);
		MerchDAO mdao = new MerchDAO();
		MerchVO mvo = new MerchVO();
		mvo.setMerchClass("���J");
		mvo.setMerchDT("���e���U10cm");
		mvo.setMerchName("������|��");
		mvo.setMerchPrice(900.0);
		mvo.setMerchID(1);
		mvo.setMerchPic1(blob);
		mvo.setMerchStatus(Byte.valueOf("1"));
		mvo.setMerchStock(999);
		mvo.setSoldTotal(0);
		mdao.update(mvo);
		System.out.println(mdao.getAll());
		fis.close();
		
	}
}
