package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private LocalDate createdDate;
    private Double totalValue;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio(Long portfolioId, LocalDate createdDate, Double totalValue,
                     Client client, List<Security> securities) {
        this.portfolioId = portfolioId;
        this.createdDate = createdDate;
        this.totalValue = totalValue;
        this.client = client;
        this.securities = securities;
    }

    public Portfolio() {}

    public Long getPortfolioId() { return portfolioId; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public Double getTotalValue() { return totalValue; }
    public void setTotalValue(Double totalValue) { this.totalValue = totalValue; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}