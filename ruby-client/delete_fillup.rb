require 'json'
require 'restclient'

id = ARGV[0]
raise 'id is required' unless id

fillup = RestClient::Resource.new('http://localhost:8080/fillup')
response = fillup["#{id}"].delete
puts 'Response Code: %d' % response.code
