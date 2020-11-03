package com.m.fraseswiki.model.items;

public class ItemRowsItem {
	private int relacionadaId;
	private String frase;
	private int opuestoId;
	private int obraId;
	private int id;
	private int verMasId;
	private int tema_id;
	private String obra;

	public String getAutor(){
		return obra;
	}
	public int getRelacionadaId(){
		return relacionadaId;
	}

	public String getFrase(){
		return frase;
	}

	public int getOpuestoId(){
		return opuestoId;
	}

	public int getObraId(){
		return obraId;
	}

	public int getId(){
		return id;
	}

	public int getVerMasId(){
		return verMasId;
	}

	public int getTema_id(){
		return tema_id;
	}
}
