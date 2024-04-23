package io.security.springsecuritymaster;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionInfoService {

    private final SessionRegistry sessionRegistry;

    public void sessionInfo() {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        for (Object allPrincipal : allPrincipals) {
            List<SessionInformation> allSessions = sessionRegistry.getAllSessions(allPrincipal, false);
            for (SessionInformation allSession : allSessions) {
                System.out.println("사용자 : " + allPrincipal + " 세션ID: " + allSession.getSessionId() + " 최종 요청 시간 : "
                        + allSession.getLastRequest());
            }
        }
    }
}
