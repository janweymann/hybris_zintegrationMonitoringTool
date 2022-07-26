package com.integrationtool.interceptor;

import com.integrationtool.model.ZProposedSolutionModel;
import de.hybris.platform.inboundservices.model.InboundRequestErrorModel;
import com.integrationtool.dao.impl.ZSolutionDaoImpl;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.hsqldb.lib.StringUtil;

import java.util.List;

public class Error2ZProposedSolutionInterceptor implements PrepareInterceptor {

    private ZSolutionDaoImpl zSolutionDaoImpl;
    private List<ZProposedSolutionModel> solutionList = null;

    @Override
    public void onPrepare(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if (o instanceof InboundRequestErrorModel) {
            final InboundRequestErrorModel errorModel = (InboundRequestErrorModel) o;
            String errorCode = errorModel.getCode();
            if (!StringUtil.isEmpty(errorCode)) {
                solutionList = this.zSolutionDaoImpl.getProposedSolutionByErrorCode(errorCode);
                if (solutionList != null) {
                    errorModel.setProposedSolution(solutionList);
                }
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

