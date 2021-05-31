POST /MessageService HTTP/1.1
<?xml version="1.0" encoding="UTF-8"?>
<message>
	<head>
		<version>1.0</version>
		<serviceType>AuthenService</serviceType>
	</head>
	<body>
		<clientInfo>
			<clientIP>0:0:0:0:0:0:0:1</clientIP>
		</clientInfo>
		<appId>UIAS</appId>
		<authen>
			<authCredential authMode="cert">
				<detach>MIID0AYJKoZIhvcNAQcCoIIDwTCCA70CAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHAaCCAqMwggKfMIICCKADAgECAghtXlzt9otVuTANBgkqhkiG9w0BAQUFADBFMQswCQYDVQQGEwJDTjEMMAoGA1UEChMDSklUMRcwFQYDVQQLEw53d3cuaml0LmNvbS5jbjEPMA0GA1UEAxMGSklUIENBMB4XDTE0MDMyNDA4NDM0N1oXDTI0MDMyMTA4NDM0N1owWDELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0pJVDElMCMGCSqGSIb3DQEJARYWeWFubWluZ19kYWlAaml0LmNvbS5jbjEUMBIGA1UEAwwLeWFubWluZ19kYWkwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAKfr28wBXNWZgiVR1UiCyj4Oyy/6x1rJv8FJeUlfi/gakA6gpWYClteqDTtz5IGPyF06JpkNXNrNJKubcvL3H9R14/b/BZ8G+YEuKOdvbcjmz2Bx0d+GAG8csQsw+57dQmMJ8j97gs5jXcG/ny0cg/26kuc2D8Ny5oYHkmhX/YFVAgMBAAGjgYQwgYEwHwYDVR0jBBgwFoAUz1a1tP/Xq/ZbpGLSLpuLoR8s0AcwHQYDVR0OBBYEFCva3kNAtXAQPdPdWWAOma9rUcrFMAsGA1UdDwQEAwIE8DAyBgNVHR8EKzApMCegJaAjhiFodHRwOi8vaml0Y3JsLmppdC5jb20uY24vY3JsNS5jcmwwDQYJKoZIhvcNAQEFBQADgYEAGivU+ybKRl/d/uSkmv/5bGw1tK/1VzYFcLwMHrf0bixZYeOADRXO/xujYwtmrkPda20anAwQE9T5EbJLFVn8HWCOaEuIIk2+NH4p6H4vQkwHnJpqBirsib60NYJS/WTOwnt96a8U1KB/LpkazNMtOlRjsEGuQycwdQPSYOyw9zoxgfYwgfMCAQEwUTBFMQswCQYDVQQGEwJDTjEMMAoGA1UEChMDSklUMRcwFQYDVQQLEw53d3cuaml0LmNvbS5jbjEPMA0GA1UEAxMGSklUIENBAghtXlzt9otVuTAJBgUrDgMCGgUAMA0GCSqGSIb3DQEBAQUABIGAKfvJif66mxiwtVZltRvzaRrXpEDuFV1iKyN/a4oQVI1pEvrU/OT+ItGcxr+shhAXR6o0OOXqR8DIeUQ2SnpE2nRlU+YuHcxcXWpGhR3eip5ToL86a02diVMLNkdJyS/G2lvVctSL5aWR5x/RVkUNHTG3X4laGCEd2OdeWe9FoEE=</detach>
				<original>c25feWFubWluZ19kYWl8aWFtaWQteWFubWluZ19kYWl8MHw4ZDllZmI3OGM0NjFhZTEwZWE5ZmU1MGUwODhjZWFhYg==</original>
			</authCredential>
		</authen>
		<accessControl>true</accessControl>
		<attributes attributeType="all"/>
	</body>
</message>

HTTP/1.0 200 OK

<?xml version="1.0" encoding="UTF-8"?>
<message>
	<head>
		<version>1.0</version>
		<serviceType>AuthenService</serviceType>
		<messageState>false</messageState>
	</head>
	<body>
		<accessControlResult>Permit</accessControlResult>
		<authResultSet allFailed="true">
			<authResult authMode="cert" success="true"/>
		</authResultSet>
		<attributes>
			<attr name="X509Certificate.NotAfter" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">2024年03月21日 16:43:47</attr>
			<attr name="X509Certificate.Base64" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">MIICnzCCAgigAwIBAgIIbV5c7faLVbkwDQYJKoZIhvcNAQEFBQAwRTELMAkGA1UEBhMCQ04xDDAKBgNVBAoTA0pJVDEXMBUGA1UECxMOd3d3LmppdC5jb20uY24xDzANBgNVBAMTBkpJVCBDQTAeFw0xNDAzMjQwODQzNDdaFw0yNDAzMjEwODQzNDdaMFgxCzAJBgNVBAYTAkNOMQwwCgYDVQQKDANKSVQxJTAjBgkqhkiG9w0BCQEWFnlhbm1pbmdfZGFpQGppdC5jb20uY24xFDASBgNVBAMMC3lhbm1pbmdfZGFpMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCn69vMAVzVmYIlUdVIgso+Dssv+sdayb/BSXlJX4v4GpAOoKVmApbXqg07c+SBj8hdOiaZDVzazSSrm3Ly9x/UdeP2/wWfBvmBLijnb23I5s9gcdHfhgBvHLELMPue3UJjCfI/e4LOY13Bv58tHIP9upLnNg/DcuaGB5JoV/2BVQIDAQABo4GEMIGBMB8GA1UdIwQYMBaAFM9WtbT/16v2W6Ri0i6bi6EfLNAHMB0GA1UdDgQWBBQr2t5DQLVwED3T3VlgDpmva1HKxTALBgNVHQ8EBAMCBPAwMgYDVR0fBCswKTAnoCWgI4YhaHR0cDovL2ppdGNybC5qaXQuY29tLmNuL2NybDUuY3JsMA0GCSqGSIb3DQEBBQUAA4GBABor1PsmykZf3f7kpJr/+WxsNbSv9Vc2BXC8DB639G4sWWHjgA0Vzv8bo2MLZq5D3WttGpwMEBPU+RGySxVZ/B1gjmhLiCJNvjR+Keh+L0JMB5yaagYq7Im+tDWCUv1kzsJ7femvFNSgfy6ZGszTLTpUY7BBrkMnMHUD0mDssPc6</attr>
			<attr name="X509Certificate.NotBefore" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">2014年03月24日 16:43:47</attr>
			<attr name="_saml_pki_cert_subject" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">CN=yanming_dai,E=yanming_dai@jit.com.cn,O=JIT,C=CN</attr>
			<attr name="X509Certificate.SubjectDN" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">CN=yanming_dai, EMAILADDRESS=yanming_dai@jit.com.cn, O=JIT, C=CN</attr>
			<attr name="X509Certificate.SerialNumber" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">6d5e5cedf68b55b9</attr>
			<attr name="X509Certificate.IssuerDN" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">CN=JIT CA, OU=www.jit.com.cn, O=JIT, C=CN</attr>
			<attr name="_saml_cert_subject" namespace="http://www.jit.com.cn/cinas/ias/ns/saml/saml11/X.509">CN=yanming_dai, EMAILADDRESS=yanming_dai@jit.com.cn, O=JIT, C=CN</attr>
		</attributes>
		<token>2aa30f8c-cb27-429d-9ff4-3136b775202b</token>
	</body>
</message>



<?xml version="1.0" encoding="utf-8"?>
<message xmlns="http://example.com/springboot/message">
    <head>
        <version>1.0</version>
        <serviceType>AuthenService</serviceType>
    </head>
    <body accessControl="true">
        <clientInfo>
            <clientIP>192.168.1.1</clientIP>
        </clientInfo>
        <appId>testApp</appId>
        <authen>
            <authCredential>
                <authMode>cert</authMode>
                <detach>0x34jkljkdgf</detach>
                <original>0xzqgdfglkgf</original>
            </authCredential>
        </authen>
    </body>
</message>
