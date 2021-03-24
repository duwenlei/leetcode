package com.leetcode.y2021.m03.d23;

import java.util.List;

/**
 * @author duwenlei
 **/
public class NestedIntegerImpl implements NestedInteger{
    public boolean isInteger;
    public Integer getInteger;
    public List<NestedInteger> getList;

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return getInteger;
    }

    @Override
    public List<NestedInteger> getList() {
        return getList;
    }
}
