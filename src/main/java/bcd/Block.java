/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;

/**
 *
 * @author User
 */
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable{

	private Header header;
	private Transaction tranx;

	//overloaded constructor
	public Block( String previousHash ) {
		this.header = new Header();
		this.header.previousHash = previousHash;
		this.header.timeStamp = new Timestamp( System.currentTimeMillis() ).getTime();
		//for now, hard-coded merkle root
		this.header.merkleRoot = "6a1f0ff1286e440668aebc80861afecb2161ff2f06f195531e3edb4ec9099c82";
		byte[] blockBytes = getBytes( this );
		this.header.currentHash = Hasher.hash( blockBytes, "SHA-256" );
	}


	public Block(int index, String previousHash, String orderID, String username, Transaction tranx, String merkleRootStr) {
		this.header = new Header();
		this.header.index = index;
		this.header.previousHash = previousHash;
		this.header.orderID = orderID;
		this.header.timeStamp = new Timestamp(System.currentTimeMillis()).getTime();
		this.header.username = username;
		this.header.merkleRoot = merkleRootStr;
		this.tranx = tranx;
		byte[] blockBytes = getBytes(this);
		this.header.currentHash = Hasher.hash(blockBytes, "SHA-256");
	}


	public void setTranx(Transaction tranx) {
		this.tranx = tranx;
	}

	public Header getHeader() {
		return header;
	}

	public class Header implements Serializable {
		// define properties
		private int index;
		private String currentHash;
		private String previousHash;
		private long timeStamp;
		private String merkleRoot;
		private String orderID;
		private String username;
		
		//getset methods
		
		public int getIndex() {
			return index;
		}

		@Override
		public String toString() {
			return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
					+ ", timeStamp=" + timeStamp + "]";
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getCurrentHash() {
			return currentHash;
		}

		public void setCurrentHash(String currentHash) {
			this.currentHash = currentHash;
		}

		public String getPreviousHash() {
			return previousHash;
		}

		public void setPreviousHash(String previousHash) {
			this.previousHash = previousHash;
		}

		public long getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
		}
		
		

	}

	//getBytes( Block ) : byte[]
	private byte[] getBytes( Block block ){
		
		try( ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			 ObjectOutputStream out = new ObjectOutputStream( baos );	
				) {
			out.writeObject( block );
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	@Override
	public String toString() {
		return "Block [header=" + header + ", tranx=" + tranx + "]";
	}
 	
}