˵����

1.eurekaServerΪע�����ģ�����ע�����

2.redisService��dbService�ֱ�Ϊredis�����mysql���ݿ����

3.springWeb Ϊweb�ͻ��ˡ�

4.����ֻ��ʾredis�Ļ�����񡢱����������������ļ�·�ɺͰ�ȫ���ܡ�

������Ŀ��

1.������eurekaServer��

2.����redisService,�����ɹ��󼴿�ע��redis����eurekaServer��

3.����springWeb��

4.�������µ�ַ�鿴����ע�������
  
  http://localhost:8761/
  
  
������ʾ��

1.�����������ӿɽ��û���Ϣд�뵽redis�����У���ʾ���õ��û���Ϣ����hardcode��ʽ��

http://localhost:8888/cache/setUserList
  
2.��������������֤�����Ƿ�ɹ���

http://localhost:8888/cache/getUserList
  
3.�����������ӵ���redis���񲢽��û���Ϣ��ʾ��ҳ���ϣ�

http://localhost:8080/web/index
  
  
note��
������û���Ϣ keyΪ"userList"��