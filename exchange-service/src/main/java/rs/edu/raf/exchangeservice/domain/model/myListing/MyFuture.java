package rs.edu.raf.exchangeservice.domain.model.myListing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFuture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myFutureId;
    private String contractName;
    private int contractSize;
    private String contractUnit;
    private int maintenanceMargin;
    private String type;
    @Version
    private Integer version;
}
