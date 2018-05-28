package ASOserver.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "PROMOTION")
public class Promotion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROMOTION_ID")
    private Long PromotionId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, unique = true)
    private String description;
    @Column(name = "DATE_FROM", nullable = false, unique = true)
    private String dateFrom;
    @Column(name = "DATE_TO", nullable = false, unique = true)
    private String dateTo;
    @Column(name = "PRECENR", nullable = false, unique = true)
    private double percent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificService;

}