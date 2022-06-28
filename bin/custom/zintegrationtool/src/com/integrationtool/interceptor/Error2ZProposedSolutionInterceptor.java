package com.integrationtool.interceptor;

import com.integrationtool.jalo.ZProposedSolution;
import com.integrationtool.model.ZProposedSolutionModel;
import de.hybris.platform.inboundservices.model.InboundRequestErrorModel;
import com.integrationtool.dao.impl.ZSolutionDaoImpl;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import org.hsqldb.lib.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;


public class Error2ZProposedSolutionInterceptor implements PrepareInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(Error2ZProposedSolutionInterceptor.class);

    private ZSolutionDaoImpl zSolutionDaoImpl;

    private List<ZProposedSolutionModel> solutionList;

    @Override
    public void onPrepare(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if (o instanceof InboundRequestErrorModel){
            LOG.info("test");
            final InboundRequestErrorModel errorModel = (InboundRequestErrorModel) o;
            String errorCode = errorModel.getCode();
            if (!StringUtil.isEmpty(errorCode)) {
            solutionList = this.zSolutionDaoImpl.getProposedSolutionByErrorCode(errorCode);
            LOG.info(("Ergebnis:"));
            errorModel.setProposedSolution(solutionList);
           // getModelService().save(errorModel);
            }
        }
    }

    public ZSolutionDaoImpl getzSolutionDaoImpl() {
        return zSolutionDaoImpl;
    }

    public void setzSolutionDaoImpl(ZSolutionDaoImpl zSolutionDaoImpl) {
        this.zSolutionDaoImpl = zSolutionDaoImpl;
    }

    public List<ZProposedSolutionModel> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<ZProposedSolutionModel> solutionList) {
        this.solutionList = solutionList;
    }

}

