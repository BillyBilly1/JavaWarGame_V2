package domain.entity;

public final class RangeConstant {

    private RangeConstant() {}


    public static final int[][] meleeAttackRange =
            new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};

    public static final int[][] threeCellRangedAttackRange =
            new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
                    {-3, 0}, {-2, 1}, {-2, 0}, {-2, -1}, {-1, 2}, {-1, -2}, {0, 3}, {0, 2},
                    {0, -2}, {0, -3}, {1, 2}, {1, -2}, {2, 1}, {2, 0}, {2, -1}, {3, 0}};

    public static final int[][] fourCellRangedAttackRange = new int[][]{};

    public static final int[][] normalDamageRange = new int[][]{{0, 0}};

    public static final int[][] limitedExplosionDamageRange =
            new int[][]{{0, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public static final int[][] extensiveExplosionDamageRange =
            new int[][]{{0, 0}, {-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}};


}
