package phonesale.api.output;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import phonesale.entity.productEntity;

@Data
public class productOutout {
    private int page;
    private int totalPage;
    private List<productEntity> products = new ArrayList<>();

}
