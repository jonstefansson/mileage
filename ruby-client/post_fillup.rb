require 'json'
require 'restclient'

fillup = RestClient::Resource.new('http://localhost:8080/fillup')

open('fillup.json', 'r') do |f|
	response = fillup.post JSON.generate(JSON.load(f)), {:content_type => :json, :accept => :json}
	puts 'Response Code: %d' % response.code
	puts 'Location:      %s' % response.headers[:location]
end
