package com.integrationtool.dao;

import com.integrationtool.model.ZProposedSolutionModel;

import java.util.List;
import java.util.Map;

public interface ZSolutionDao<T extends ZProposedSolutionModel> {

    List<ZProposedSolutionModel> getProposedSolutionByErrorCode(final String errorCode);
    }

