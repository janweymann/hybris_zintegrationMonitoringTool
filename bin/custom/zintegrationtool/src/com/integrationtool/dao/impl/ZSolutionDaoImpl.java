package com.integrationtool.dao.impl;

import com.integrationtool.dao.ZSolutionDao;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.integrationtool.model.ZProposedSolutionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

@Component
public class ZSolutionDaoImpl extends AbstractItemDao implements ZSolutionDao {
    private static final Logger LOG = LoggerFactory.getLogger(ZSolutionDaoImpl.class);


    final private static String QUERY_GET_TEMPLATE_BY_ERRORCODE = "SELECT {" + Item.PK + "} FROM {"
            + ZProposedSolutionModel._TYPECODE + "} WHERE {" + ZProposedSolutionModel.ERRORCODE + "} = ?errorCode";
    @Override
    public List<ZProposedSolutionModel> getProposedSolutionByErrorCode(final String errorCode) {

        validateParameterNotNull(errorCode, "ErrorCode must not be null");
        List<ZProposedSolutionModel> result = null;

        final Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("errorCode", errorCode);

        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(QUERY_GET_TEMPLATE_BY_ERRORCODE);
        fQuery.addQueryParameters(queryParams);
        fQuery.setResultClassList(Collections.singletonList(ZProposedSolutionModel.class));
        final SearchResult<ZProposedSolutionModel> searchResult = search(fQuery);

        if (searchResult != null) {
            result = searchResult.getResult();

        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("No Solution item was found with error code: " + errorCode);
            }
        }
        return result;
    }
}