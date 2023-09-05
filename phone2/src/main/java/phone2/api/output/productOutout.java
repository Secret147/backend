package phone2.api.output;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import phone2.entity.productEntity;

@Data
public class productOutout {
    private int page;
    private int totalPage;
    private List<productEntity> products = new ArrayList<>();

}
