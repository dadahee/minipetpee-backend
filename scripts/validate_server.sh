echo '======================='
echo 'Running validate_server'
echo '======================='

result=$(curl -s -o /dev/null -w "%{http_code}" http://127.0.0.1/aws/health)

echo Check http://127.0.0.1/aws/health
echo $result

if [[ "$result" =~ "200" ]]; then
  exit 0
else
  exit 1
fi