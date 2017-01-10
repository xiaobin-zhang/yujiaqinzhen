--H2默认1秒超时，在运行批量测试时有时会有问题
SET DEFAULT_LOCK_TIMEOUT 50000;

create alias TO_DATE as '
java.util.Date toDate(String s , String pattern) throws Exception{
  pattern = pattern.replaceAll("mm","MM");
  pattern = pattern.replaceAll("hh24","HH");
  pattern = pattern.replaceAll("mi","mm");
  return new java.text.SimpleDateFormat(pattern).parse(s);
}
';

create alias days as '
long getDays(java.util.Date date) throws Exception{
  return date.getTime() / 3600 / 1000 / 24;
}
';
--CREATE SEQUENCE SEQ_BALANCE_ACCT START WITH 158794 BELONGS_TO_TABLE;
create alias date as '
java.util.Date getDate(int days) throws Exception{
  return new java.util.Date( days * 3600 * 1000 * 24);
}
';