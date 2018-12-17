package main;

public class GoodsType {

    private class Apple {
        private static final int IDAPPLE = 0;
        private static final int PROFIT = 2;
        private static final int PENALTY = 2;
        private static final int QUEENSBONUS = 10;
        private static final int KINGSPBONUS = 20;
    }
    private class Cheese {
        private static final int IDCHEESE = 1;
        private static final int PROFIT = 3;
        private static final int PENALTY = 2;
        private static final int QUEENSBONUS = 10;
        private static final int KINGSPBONUS = 15;
    }
    private class Bread {
        private static final int IDBREAD = 2;
        private static final int PROFIT = 4;
        private static final int PENALTY = 2;
        private static final int QUEENSBONUS = 10;
        private static final int KINGSPBONUS = 15;
    }
    private class Chicken {
        private static final int IDCHICKEN = 3;
        private static final int PROFIT = 4;
        private static final int PENALTY = 2;
        private static final int QUEENSBONUS = 5;
        private static final int KINGSPBONUS = 10;
    }
    private class Silk {
        private static final int IDSILK = 10;
        private static final int PROFIT = 9;
        private static final int PENALTY = 4;
    }
    private class Pepper {
        private static final int IDPEPPER = 11;
        private static final int PROFIT = 8;
        private static final int PENALTY = 4;
    }
    private class Barrel {
        private static final int IDBARREL = 12;
        private static final int PROFIT = 7;
        private static final int PENALTY = 4;
    }


    public final int getProfit(final int id) {
        switch (id) {
            case Apple.IDAPPLE :
                return Apple.PROFIT;
            case Cheese.IDCHEESE :
                return Cheese.PROFIT;
            case Bread.IDBREAD :
                return Bread.PROFIT;
            case Chicken.IDCHICKEN :
                return Chicken.PROFIT;
            case Silk.IDSILK :
                return Silk.PROFIT;
            case Pepper.IDPEPPER :
                return Pepper.PROFIT;
            case Barrel.IDBARREL :
                return Barrel.PROFIT;
            default:
                return 0;
        }
    }

    public final int getPenalty(final int id) {
        switch (id) {
            case Apple.IDAPPLE :
                return Apple.PENALTY;
            case Cheese.IDCHEESE :
                return Cheese.PENALTY;
            case Bread.IDBREAD :
                return Bread.PENALTY;
            case Chicken.IDCHICKEN :
                return Chicken.PENALTY;
            case Silk.IDSILK :
                return Silk.PENALTY;
            case Pepper.IDPEPPER :
                return Pepper.PENALTY;
            case Barrel.IDBARREL :
                return Barrel.PENALTY;
            default:
                return 0;
        }
    }

    public final int getKingsBonus(final int id) {
        switch (id) {
            case Apple.IDAPPLE :
                return Apple.KINGSPBONUS;
            case Cheese.IDCHEESE :
                return Cheese.KINGSPBONUS;
            case Bread.IDBREAD :
                return Bread.KINGSPBONUS;
            case Chicken.IDCHICKEN :
                return Chicken.KINGSPBONUS;
            default:
                return 0;
        }
    }
    public final int getQueensBonus(final int id) {
        switch (id) {
            case Apple.IDAPPLE :
                return Apple.QUEENSBONUS;
            case Cheese.IDCHEESE :
                return Cheese.QUEENSBONUS;
            case Bread.IDBREAD :
                return Bread.QUEENSBONUS;
            case Chicken.IDCHICKEN :
                return Chicken.QUEENSBONUS;
            default:
                return 0;
        }
    }

}
