package gameplay;

import main.GoodsType;
import java.util.Comparator;

public class ProfitComparator implements Comparator<Integer> {
    @Override
    public int compare(final Integer id1, final Integer id2) {
        GoodsType goodsType = new GoodsType();
        return goodsType.getProfit(id2) - goodsType.getProfit(id1);
    }

}
