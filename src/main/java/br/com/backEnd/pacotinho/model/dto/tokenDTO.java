package br.com.backEnd.pacotinho.model.dto;

public class tokenDTO {
    private String token;

    public tokenDTO(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
