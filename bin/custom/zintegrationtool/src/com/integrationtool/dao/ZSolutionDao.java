package com.integrationtool.dao;

import com.integrationtool.model.ZProposedSolutionModel;
import java.util.List;

public interface ZSolutionDao {

    List<ZProposedSolutionModel> getProposedSolutionByErrorCode(final String errorCode);
}

