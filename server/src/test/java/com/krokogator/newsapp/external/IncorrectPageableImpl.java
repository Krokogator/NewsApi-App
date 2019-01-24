package com.krokogator.newsapp.external;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class IncorrectPageableImpl implements Pageable {
    @Override
    public int getPageNumber() {
        return -5;
    }

    @Override
    public int getPageSize() {
        return -10;
    }

    @Override
    public long getOffset() {
        return -2;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
