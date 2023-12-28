// Copyright (c) 2023 Yida Li (GitHub: BillyBilly1)
// All rights reserved.
// This code may not be reproduced, modified, distributed,
// or used in any manner except in accordance with the terms
// specified in a written agreement.

import domain.entity.unit.IUnit;
import domain.entity.unit.IUnitFactory;
import domain.entity.unit.UnitFactory;
import domain.service.id.SingletonIntegerIDGenerator;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        IUnitFactory iUnitFactory = new UnitFactory(SingletonIntegerIDGenerator.getInstance());
        IUnit unit = iUnitFactory.createUnit("SpearGuard", 1, 2, false);
        IUnit unit1 = iUnitFactory.createUnit("LanceKnight", 2, 3, false);
        System.out.println(unit.getX());
        System.out.println(unit.getDefense());
        System.out.println(unit.getName());
        System.out.println(unit.getId());
        System.out.println(unit1.getId());
        System.out.println(unit1.getName());
        JFrame jFrame = new JFrame("");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel iconLabel = new JLabel(
                new ImageIcon(unit1.getDisplayedIcon().getImage().getScaledInstance(
                        378, 378, Image.SCALE_SMOOTH)));
        jFrame.setLayout(new FlowLayout());
        jFrame.add(iconLabel);

        jFrame.setPreferredSize(new Dimension(400, 400));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); // 中心位置
        jFrame.setVisible(true);
    }
}
